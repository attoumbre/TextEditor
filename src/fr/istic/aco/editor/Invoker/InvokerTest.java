package fr.istic.aco.editor.Invoker;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.istic.aco.editor.Command.Command;
import fr.istic.aco.editor.Command.CopyCommand;
import fr.istic.aco.editor.Command.CutCommand;
import fr.istic.aco.editor.Command.DeleteCommand;
import fr.istic.aco.editor.Command.InsertCommand;
import fr.istic.aco.editor.Command.PastCommand;
import fr.istic.aco.editor.Command.SelectionCommand;
import fr.istic.aco.editor.Command.StartCommand;
import fr.istic.aco.editor.Command.StopCommand;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Receiver.EngineImpl;
import fr.istic.aco.editor.Recorder.Recorder;
import fr.istic.aco.editor.Recorder.RecorderImpl;

public class InvokerTest {

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
        copy = new CopyCommand(engine, recorder);
        past = new PastCommand(engine, recorder);
        insert = new InsertCommand(engine, recorder, invoker);
        delete = new DeleteCommand(engine, recorder);
        select = new SelectionCommand(engine, recorder, invoker);
        cut = new CutCommand(engine, recorder);
        start = new StartCommand(recorder);
        stop = new StopCommand(recorder);
        
        invoker.addCommand(copy, "copier");
    	invoker.addCommand(cut, "couper");
    	invoker.addCommand(select, "selection");
    	invoker.addCommand(delete, "delete");
    	invoker.addCommand(insert, "insertion");
    	invoker.addCommand(past, "coller");
        	
    }
    
   
    
    @Test
    void addCommand() {
    	assertThrows(IllegalArgumentException.class, ()->{invoker.addCommand(copy, null);});
    	assertThrows(IllegalArgumentException.class, ()->{invoker.addCommand(null, null);});
    	assertThrows(IllegalArgumentException.class, ()->{invoker.addCommand(null, null);});
    	
   
    }	
    
    
    @Test
    void playCommand() {
   
    	start.execute();
    	assertThrows(IllegalArgumentException.class, ()->{invoker.playCommand(null);});
    	String content = "Salut tout le monde";
        invoker.setElement(content);
        invoker.playCommand("insertion");
        
        stop.execute();
        assertEquals("Salut tout le monde",engine.getBufferContents());

    }

}
