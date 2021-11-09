package fr.istic.aco.editor.command;

import fr.istic.aco.editor.receiver.EngineImpl;

public class CutCommand implements Command{

private final EngineImpl engine;
	
	public CutCommand(EngineImpl engine) {
		this.engine = engine;
	}
	
	@Override
	public void Execute() {
		this.engine.cutSelectedText();
	}


}
