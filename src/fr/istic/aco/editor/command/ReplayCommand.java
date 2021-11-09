package fr.istic.aco.editor.command;

import fr.istic.aco.editor.recorder.RecorderImpl;

public class ReplayCommand implements Command {

	private final  RecorderImpl recoder;
	
	public ReplayCommand (RecorderImpl recorder) {
		this.recoder = recorder;
	}
	
	@Override
	public void Execute() {
		this.recoder.recoderReplay();

	}

}
