package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recorder;

public class CutCommand implements Command{

	private Engine engine;
	private Recorder recorder;
	
	public CutCommand(Engine engine, Recorder recorder) {
		this.engine=engine;
		this.recorder= recorder;
		
	}
	
	@Override
	public void Execute() {
		engine.cutSelectedText();
		recorder.save(CutCommand.this);
	}

}
