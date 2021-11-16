package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Receiver.Engine;

public class CutCommand implements Command{

	private Engine engine;

	
	public CutCommand(Engine engine) {
		this.engine=engine;
		
	}
	@Override
	public void Execute() {
		engine.cutSelectedText();
	}

}
