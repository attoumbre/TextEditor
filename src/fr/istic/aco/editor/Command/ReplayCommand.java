package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Recorder.RecorderImpl;

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
