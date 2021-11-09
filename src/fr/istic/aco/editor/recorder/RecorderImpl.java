package fr.istic.aco.editor.recorder;

import fr.istic.aco.editor.command.Command;

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

