package fr.istic.aco.editor.Recorder;

import fr.istic.aco.editor.Command.Command;

public class RecorderImpl implements Recoder {
    
	private Command lastCom;
	
	@Override
	public Command recoderSave(Command c) {
		this.lastCom=c;
		return lastCom;
	}

	@Override
	public void recoderReplay() {
		this.lastCom.Execute();
	}

}

