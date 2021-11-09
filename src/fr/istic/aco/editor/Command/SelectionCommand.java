package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Receiver.Engine;

public class SelectionCommand implements Command{

	private Engine engine;
	
	
	public SelectionCommand(Engine engine) {
		this.engine=engine;
		
	}
	
	@Override
	public void Execute() {
		engine.getSelection();
		
	}
}
