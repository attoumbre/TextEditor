package fr.istic.aco.editor.command;

import fr.istic.aco.editor.recorder.RecorderImpl;


public class SaveCommand implements Command {
	private final RecorderImpl recoder;
	private Command command;
	
	public SaveCommand(RecorderImpl recoder, Command command) {
		this.recoder = recoder;
		this.command = command;
	}
	
	
	@Override
	public void Execute() {
		this.recoder.recoderSave(this.command);

	}

}
