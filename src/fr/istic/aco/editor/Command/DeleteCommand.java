package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recorder;

public class DeleteCommand implements Command{
	
	
	private Engine engine;
	private Recorder recorder;
	
	public DeleteCommand(Engine engine, Recorder recorder ) {
	
		this.engine=engine;
		this.recorder= recorder;
	}

	@Override
	public void Execute() {
		engine.delete();
		recorder.save(DeleteCommand.this);
		
	}

}
