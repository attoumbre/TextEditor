package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Receiver.Engine;

public class PastCommand implements Command{

	private Engine engine;
	
	
	public PastCommand(Engine engine) {
		this.engine=engine;
		
	}
	
	@Override
	public void Execute() {
		engine.pasteClipboard();
		
	}

}
