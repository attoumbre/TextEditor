package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Recorder.Recorder;

public class StopCommand implements Command{

	private Recorder recorder;
	StopCommand(Recorder recorder){
		this.recorder= recorder;
	}
	
	@Override
	public void execute() {

		recorder.stop();
		
	}


	
}
