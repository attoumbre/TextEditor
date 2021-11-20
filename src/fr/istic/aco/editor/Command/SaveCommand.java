package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Recorder.Recorder;

public class SaveCommand implements Command {
	private Recorder recoder;
	private Command command;
	
	public SaveCommand(Recorder recoder, Command command) {
		this.recoder = recoder;
		this.command = command;
	}
	
	
	@Override
	public void Execute() {
		this.recoder.save(command);

	}

}
