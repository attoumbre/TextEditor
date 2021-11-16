package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Recorder.RecorderImpl;

public class Replay implements Command{
    private RecorderImpl recoder;
    
    public Replay (RecorderImpl recoder_) {
    	this.recoder=recoder_;
    }
	@Override
	public void Execute() {
		recoder.replay();
	}

}
