package fr.istic.aco.editor.command;

import fr.istic.aco.editor.receiver.EngineImpl;

public class DeleteCommand implements Command {

private final EngineImpl engine;
	
	public DeleteCommand(EngineImpl engine) {
		this.engine = engine;
	}
	
	@Override
	public void Execute() {
		this.engine.delete();
		//System.out.print("delete");
	}


}
