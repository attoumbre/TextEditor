package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Recorder.Recorder;

public class StartCommand implements Command {

	private Recorder recorder;
	StartCommand(Recorder recorder){
		this.recorder = recorder;
	}
	
	
	@Override
	public void execute() {

		recorder.start();
		
	}


}
