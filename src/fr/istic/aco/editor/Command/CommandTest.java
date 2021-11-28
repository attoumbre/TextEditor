package fr.istic.aco.editor.Command;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

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


	    /**
	     * Initialisation des classes utiliser a chaque demarrage de Test
	     */
	    @org.junit.jupiter.api.BeforeEach
	    void setUp() {
	        engine = new EngineImpl();
	        recorder = new RecorderImpl();
	        invoker = new InvokerImpl();

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
	        String mot = "Bienvenu copy";
	        engine.insert(mot);
	        Selection selection = engine.getSelection();
	        selection.setEndIndex(3);
	        selection.setBeginIndex(1);
	        
	        Command copy = new CopyCommand(engine);
	        copy.execute();
	        assertEquals(engine.getClipboardContents(), "ie");
	        assertEquals(engine.getBufferContents(), mot);

	    }

	    @Test
	    void cutCommand() {
	        String mot = "Bienvenu cut";
	        engine.insert(mot);
	        Selection selection = engine.getSelection();
	        selection.setEndIndex(4);
	        selection.setBeginIndex(0);
	        
	        Command cut = new CutCommand(engine);
	        cut.execute();
	        assertEquals(engine.getClipboardContents(), "Bien");
	        assertEquals(engine.getBufferContents(), "venu cut");

	    }

	    @Test
	    void deleteCommand() {
	        String mot = "Bienvenu delete";
	        engine.insert(mot);
	        Selection selection = engine.getSelection();
	        
	        selection.setEndIndex(4);
	        selection.setBeginIndex(1);
	        
	        Command delete = new DeleteCommand(engine);
	        delete.execute();
	        assertEquals(engine.getBufferContents(), "Bvenu delete");
	    }

	    @Test
	    void pastCommand() {
	        String mot = "Bienvenu paste";
	        engine.insert(mot);
	        Selection selection = engine.getSelection();
	        selection.setEndIndex(9);
	        selection.setBeginIndex(8);
	        
	        engine.copySelectedText();
	        engine.pasteClipboard();
	        assertEquals(mot, engine.getBufferContents());
	        Command paste = new PastCommand(engine);
	        paste.execute();
	    }

	    @Test
	    void selectionCommand() {
	        String content = "Salut tout le monde";
	        engine.insert(content);
	        
	        invoker.setIndexF(5);
	        invoker.setIndexB(0);
	        Command selection = new SelectionCommand(engine, recorder,invoker);
	        
	        selection.execute();

	        Command copy = new CopyCommand(engine);
	        copy.execute();

	        assertEquals(engine.getClipboardContents(), "Salut");
	    }

	    @Test
	    void insertCommmand() {
	        String mot = "Bienvenu Insert";
	        invoker.setElement(mot);
	        Command insert = new InsertCommand(engine, recorder , invoker);
	        insert.execute();
	        assertEquals(engine.getBufferContents(), mot);

	    }

}
