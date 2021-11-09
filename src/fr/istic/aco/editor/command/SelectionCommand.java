package fr.istic.aco.editor.command;

import fr.istic.aco.editor.invoker.InvokerImpl;
import fr.istic.aco.editor.receiver.EngineImpl;

public class SelectionCommand implements Command {

	private EngineImpl engine;
	private InvokerImpl invoker;

	public SelectionCommand(EngineImpl engine , InvokerImpl invoker)  {
		this.engine=engine;
		this.invoker=invoker;
	}
	
	@Override
	public void Execute() {
		this.engine.getSelection().setEndIndex(invoker.getEnd());
		this.engine.getSelection().setBeginIndex(invoker.getBegin());
		
	}


}
