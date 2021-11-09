package fr.istic.aco.editor.command;

import fr.istic.aco.editor.receiver.EngineImpl;

public class PastCommand implements Command {

private final EngineImpl engine;
	
	public PastCommand(EngineImpl engine) {
		this.engine = engine;
	}
	
	@Override
	public void Execute() {
		this.engine.pasteClipboard();
		//System.out.print("paste");
	}

}

