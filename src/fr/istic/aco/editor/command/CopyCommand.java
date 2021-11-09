package fr.istic.aco.editor.command;

import fr.istic.aco.editor.receiver.EngineImpl;

public class CopyCommand implements Command {

private final EngineImpl engine;
	
	public CopyCommand(EngineImpl engine) {
		this.engine = engine;
	}
	
	@Override
	public void Execute() {
		this.engine.copySelectedText();
		
	}

}
