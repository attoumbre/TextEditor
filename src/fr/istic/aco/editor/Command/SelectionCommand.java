package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Invoker.InvokerImpl;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Receiver.Selection;

public class SelectionCommand implements Command{

	private Engine engine;
	private InvokerImpl invoker;
	
	
	public SelectionCommand(Engine engine, InvokerImpl invoker) {
		this.engine=engine;
		this.invoker=invoker;
		
	}
	
	@Override
	public void Execute() {
		
		
		Selection selection=engine.getSelection();
		
		selection.setEndIndex(invoker.getIndexF());
		selection.setBeginIndex(invoker.getIndexB());
		
	}
}
