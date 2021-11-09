package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Invoker.InvokerImpl;
import fr.istic.aco.editor.Receiver.Engine;

public class InsertCommand implements Command{
	
	private Engine engine;
	private InvokerImpl invoker;
	
	public InsertCommand(Engine engine, InvokerImpl invoker) {
		this.engine= engine;
		this.invoker=invoker;
	}

	/**
	 * inserer un string
	 */
	@Override
	public void Execute() {
		String element = invoker.getElement();
		engine.insert(element);
		
	}

}
