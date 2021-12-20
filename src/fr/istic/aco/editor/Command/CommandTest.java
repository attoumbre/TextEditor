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
	    private Command copy;
	    private Command past;
	    private Command insert;
	    private Command delete;
	    private Command select;
	    private Command cut;
	    private Command start;
	    private Command stop;
	    private Command replay;
	    
	    /**
	     * Initialisation des classes utiliser a chaque demarrage de Test
	     */
	    @org.junit.jupiter.api.BeforeEach
	    void setUp() {
	        engine = new EngineImpl();
	        recorder = new RecorderImpl();
	        invoker = new InvokerImpl();
	        copy = new CopyCommand(engine, recorder);
	        past = new PastCommand(engine, recorder);
	        insert = new InsertCommand(engine, recorder, invoker);
	        delete = new DeleteCommand(engine, recorder);
	        select = new SelectionCommand(engine, recorder, invoker);
	        cut = new CutCommand(engine, recorder);
	        start = new StartCommand(recorder);
	        stop = new StopCommand(recorder);
	        replay = new ReplayCommand(recorder);
	        
	        invoker.addCommand(copy, "copier");
	    	invoker.addCommand(cut, "couper");
	    	invoker.addCommand(select, "selection");
	    	invoker.addCommand(delete, "delete");
	    	invoker.addCommand(insert, "insertion");
	    	invoker.addCommand(past, "coller");
	    	invoker.addCommand(replay, "rejouer");
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
	    	 start.execute();
	    	 String mot = "Bienvenu copy";
		     invoker.setElement(mot);
		     invoker.playCommand("insertion");
		        

		     invoker.setIndexF(3);
		     invoker.setIndexB(1);
		     invoker.playCommand("selection");
		     
		     invoker.playCommand("copier");
		        
		     stop.execute();
		    
		      
	        assertEquals(engine.getClipboardContents(), "ie");
	        assertEquals(engine.getBufferContents(), mot);

	    }

	    @Test
	    void cutCommand() {
	    	start.execute();
	        String mot = "Bienvenu cut";
	        invoker.setElement(mot);
	        invoker.playCommand("insertion");
	        
	        Selection selection = engine.getSelection();
	        invoker.setIndexB(0);
	        invoker.setIndexF(4);
	        invoker.playCommand("selection");
	        
	        invoker.playCommand("couper");
	        
	        stop.execute();
	        assertEquals(engine.getClipboardContents(), "Bien");
	        assertEquals(engine.getBufferContents(), "venu cut");
	        
	    }

	    @Test
	    void deleteCommand() {
	    	
	        String mot = "Bienvenu delete";
	        start.execute();
	        
	        invoker.setElement(mot);
	        invoker.playCommand("insertion");
	        
	        
	        invoker.setIndexB(1);
	        invoker.setIndexF(4);
	        invoker.playCommand("selection");
	        
	        invoker.playCommand("delete");
	        stop.execute();
	        
	        assertEquals(engine.getBufferContents(), "Bvenu delete");
	    }

	    @Test
	    void pastCommand() {
	    	start.execute();
	        String mot = "Bienvenu paste";
	        invoker.setElement(mot);
	        invoker.playCommand("insertion");
	        
	        invoker.setIndexB(8);
	        invoker.setIndexF(9);
	        invoker.playCommand("selection");
	        
	        invoker.playCommand("copier");
	        
	        
	        invoker.playCommand("coller");
	        stop.execute();
	        
	        assertEquals(mot, engine.getBufferContents());
	       
	    }

	    @Test
	    void selectionCommand() {
	    	start.execute();
	        String content = "Salut tout le monde";
	        invoker.setElement(content);
	        invoker.playCommand("insertion");
	        
	        invoker.setIndexB(0);
	        invoker.setIndexF(5);
	        
	        invoker.playCommand("selection");

	        invoker.playCommand("copier");
	        stop.execute();
	        
	        assertEquals("Salut",engine.getClipboardContents());
	    }

	    @Test
	    void insertCommmand() {
	    	start.execute();
	        String mot = "Bienvenu Insert";
	        invoker.setElement(mot);
	        invoker.playCommand("insertion");
	        
	        
	        
	        assertEquals(engine.getBufferContents(), mot);

	    }
	    
	    @Test
	    void replayCommand() {
	    	
	    	
	    	String mot = "Bienvenu Replay";
	    	start.execute();
	    	
	    	invoker.setElement(mot);
	    	invoker.playCommand("insertion");
		    
	    	
	    	 invoker.setIndexB(0);
		     invoker.setIndexF(5);
		        
		     invoker.playCommand("selection");
		   
		     invoker.playCommand("copier");
		   
		     invoker.setIndexF(15);
		     invoker.setIndexB(15);
		     
		        
		     invoker.playCommand("selection");
	    	
		     invoker.playCommand("coller");
	    	stop.execute();
	    	
	    	 invoker.playCommand("rejouer");
		    
		    assertEquals( "Bienvenu ReplayBienvBienvBienvenu Replay", engine.getBufferContents());


	    }
	    
	   @Test
	   void replayCommand1() {
		    
	    	String mot = "Bienvenu Replay ";
	    	start.execute();
	    	
	    	invoker.setElement(mot);
	    	invoker.playCommand("insertion");
		    
		    
		    String mot1 = "inserons encore ";
		    invoker.setElement(mot1);
	    	invoker.playCommand("insertion");
		    
		    stop.execute();
	    	 invoker.playCommand("rejouer");
			    
			assertEquals( "Bienvenu Replay inserons encore Bienvenu Replay inserons encore ", engine.getBufferContents());

	   }
	   

}
