package fr.istic.aco.editor.Command;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import fr.istic.aco.editor.Caretaker.UndoManager;
import fr.istic.aco.editor.Caretaker.UndoManagerImpl;
import fr.istic.aco.editor.Invoker.Invoker;
import fr.istic.aco.editor.Invoker.InvokerImpl;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Receiver.EngineImpl;
import fr.istic.aco.editor.Receiver.Selection;
import fr.istic.aco.editor.Recorder.Recorder;
import fr.istic.aco.editor.Recorder.RecorderImpl;

public class CommandTest {

	 	private Engine engine;
	    private Recorder recorder;
	    private Invoker invoker;
	    private UndoManager undoManager;
        //private SelectionMemento memento;
        //private InsertMemento memento2;

	    /**
	     * Initialisation des classes utiliser a chaque demarrage de Test
	     */
	    @org.junit.jupiter.api.BeforeEach
	    void setUp() {
	        engine = new EngineImpl();
	        recorder = new RecorderImpl();
	        invoker = new InvokerImpl();
	        undoManager = new UndoManagerImpl(engine);
	        //memento = new SelectionMemento();
	       // memento2 = new InsertMemento();
	    }

	    /**
	     * Inserer du text
	     * Faire une selection de début et fin
	     * Executer la commande Copy
	     * Verifier si le contenu du {@link java.awt.datatransfer.Clipboard} est l'elemnt selectionner
	     * Verifier si le contenu du buffer est le mot inserer
	     */
	    @Test
	    void copyCommand() {
	    	Command start = new StartCommand( recorder, undoManager);
	    	Command stop = new StopCommand( recorder, undoManager);
	    	
	    	start.execute();
	        String mot = "Bienvenu copy";
	        engine.insert(mot);
	        Selection selection = engine.getSelection();
	        selection.setBeginIndex(1);
	        selection.setEndIndex(3);
	        
	        Command copy = new CopyCommand(engine,recorder, undoManager);
	        copy.execute();
	        stop.execute();
	        assertEquals(engine.getClipboardContents(), "ie");
	        assertEquals(engine.getBufferContents(), mot);

	    }

	    @Test
	    void cutCommand() {
	    	Command start = new StartCommand( recorder, undoManager);
	    	Command stop = new StopCommand( recorder, undoManager);
	    	
	    	start.execute();

	        String mot = "Bienvenu cut";
	        engine.insert(mot);
	        Selection selection = engine.getSelection();
	        selection.setBeginIndex(0);
	        selection.setEndIndex(4);
	        
	        Command cut = new CutCommand(engine,recorder, undoManager);
	        cut.execute();
	        
	        stop.execute();
	        assertEquals(engine.getClipboardContents(), "Bien");
	        assertEquals(engine.getBufferContents(), "venu cut");

	    }

	    @Test
	    void deleteCommand() {
	    	Command start = new StartCommand( recorder, undoManager);
	    	Command stop = new StopCommand( recorder, undoManager);
	    	
	    	start.execute();

	        String mot = "Bienvenu delete";
	        engine.insert(mot);
	        Selection selection = engine.getSelection();
	        selection.setBeginIndex(1);
	        selection.setEndIndex(4);
	        
	        Command delete = new DeleteCommand(engine,recorder,undoManager);
	        delete.execute();
	        stop.execute();
	        assertEquals(engine.getBufferContents(), "Bvenu delete");
	    }

	    @Test
	    void pastCommand() {
	    	Command start = new StartCommand( recorder, undoManager);
	    	Command stop = new StopCommand( recorder, undoManager);
	    	
	    	start.execute();

	        String mot = "Bienvenu paste";
	        engine.insert(mot);
	        Selection selection = engine.getSelection();
	        selection.setBeginIndex(8);
	        selection.setEndIndex(9);
	        
	        engine.copySelectedText();
	        engine.pasteClipboard();
	        assertEquals(mot, engine.getBufferContents());
	        stop.execute();
//	        Command paste = new PastCommand(engine,recorder);
//	        paste.execute();
	    }

	    @Test
	    void selectionCommand() {
	    	Command start = new StartCommand( recorder, undoManager);
	    	Command stop = new StopCommand( recorder,undoManager);
	    	
	    	start.execute();

	        String content = "Salut tout le monde";
	        invoker.setElement(content);
	        invoker.setIndexB(0);
	        invoker.setIndexF(5);
	        Command insert = new InsertCommand(engine, recorder , invoker, undoManager);
	        insert.execute();
	        Command selection = new SelectionCommand(engine, recorder,invoker, undoManager);
	        
	        selection.execute();
	        
	        Command copy = new CopyCommand(engine,recorder, undoManager);
	        copy.execute();

	        stop.execute();
	        assertEquals("Salut",engine.getClipboardContents());
	    }

	    @Test
	    void insertCommmand() {
	    	Command start = new StartCommand( recorder, undoManager);
	    	Command stop = new StopCommand( recorder, undoManager);
	    	
	    	start.execute();

	        String mot = "Bienvenu Insert";
	        invoker.setElement(mot);
	        Command insert = new InsertCommand(engine, recorder , invoker, undoManager);
	        insert.execute();
	        stop.execute();
	        assertEquals(engine.getBufferContents(), mot);

	    }
	    
	    @Test
	    void replayCommand() {
	    	Command start = new StartCommand( recorder, undoManager);
	    	Command stop = new StopCommand( recorder, undoManager);
	    	String mot = "Bienvenu Replay";
	    	start.execute();
	    	
	    	System.out.println(engine.getBufferContents());
	    	invoker.setElement(mot);
		    Command insert = new InsertCommand(engine, recorder , invoker, undoManager);
		    insert.execute();
		    //System.out.println(engine.getBufferContents());
	    	
	    	invoker.setIndexB(0);
	    	invoker.setIndexF(5);
		    Command selection = new SelectionCommand(engine, recorder , invoker, undoManager);
		    selection.execute();
		   
		    Command copy = new CopyCommand(engine, recorder, undoManager);
		    copy.execute();
		   
		    invoker.setIndexB(15);
	    	invoker.setIndexF(15);
	    	selection.execute();
	    	
	    	Command past = new PastCommand(engine, recorder, undoManager);
	    	past.execute();
	    	stop.execute();
	    	
		    Command replay = new ReplayCommand(recorder);
		    
		    
		    replay.execute();
		    
		    assertEquals( "Bienvenu ReplayBienvBienvBienvenu Replay", engine.getBufferContents());

	    }
	    
	    @Test
	    void undo() {
	    	Command start = new StartCommand( recorder, undoManager);
	    	Command stop = new StopCommand( recorder, undoManager);
	    	String mot = "Bienvenu Replay";
	    	start.execute();
	    	
	    	
	    	invoker.setElement(mot);
		    Command insert = new InsertCommand(engine, recorder , invoker, undoManager);
		    insert.execute();
		   
	    	
	    	invoker.setIndexB(0);
	    	invoker.setIndexF(5);
		    Command selection = new SelectionCommand(engine, recorder , invoker, undoManager);
		    selection.execute();
		   
		    Command copy = new CopyCommand(engine, recorder, undoManager);
		    copy.execute();
		   
		    invoker.setIndexB(15);
	    	invoker.setIndexF(15);
	    	selection.execute();
	    	
	    	Command past = new PastCommand(engine, recorder, undoManager);
	    	past.execute();
	    	stop.execute();

	    	Command undo = new Undo(undoManager);
	    	undo.execute();
	    	
	    	assertEquals( "Bienvenu Replay", engine.getBufferContents());
	    
	    	
	    	
	    	
	    }
	    
	    
	    @Test
	    void redo() {
	    	Command start = new StartCommand( recorder, undoManager);
	    	Command stop = new StopCommand( recorder, undoManager);
	    	String mot = "Bienvenu Replay";
	    	start.execute();
	    	
	    	
	    	invoker.setElement(mot);
		    Command insert = new InsertCommand(engine, recorder , invoker, undoManager);
		    insert.execute();
		   
	    	
	    	invoker.setIndexB(0);
	    	invoker.setIndexF(5);
		    Command selection = new SelectionCommand(engine, recorder , invoker, undoManager);
		    selection.execute();
		   
		    Command copy = new CopyCommand(engine, recorder, undoManager);
		    copy.execute();
		   
		    invoker.setIndexB(15);
	    	invoker.setIndexF(15);
	    	selection.execute();
	    	
	    	Command past = new PastCommand(engine, recorder, undoManager);
	    	past.execute();
	    	stop.execute();

	    	Command undo = new Undo(undoManager);
	    	undo.execute();
	    	Command redo = new Redo(undoManager);
	    	redo.execute();
	    	
	    	assertEquals( "Bienvenu ReplayBienv", engine.getBufferContents());
	    
	    	
	    	
	    	
	    }
	    
	 
}
