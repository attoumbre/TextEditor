package fr.istic.aco.editor.command;

import fr.istic.aco.editor.invoker.InvokerImpl;
import fr.istic.aco.editor.receiver.EngineImpl;

public class InsertCommand implements Command{

	private EngineImpl engine;
	private InvokerImpl invoker;

    public InsertCommand(EngineImpl engine){
        this.engine = engine ;
    }
    
	@Override
    public void Execute() {    
    	this.engine.insert(invoker.getElement());
    }

}
