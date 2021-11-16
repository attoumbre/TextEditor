package fr.istic.aco.editor.Recorder;

import fr.istic.aco.editor.Command.Command;

public class RecorderImpl implements Recorder {
	private Command lastCommand;

	public Command getLastCommand() {
		return lastCommand;
	}

	@Override
	public Command save(Command c) {
		this.lastCommand=c;
		return lastCommand;
	}

	@Override
	public void replay() {
		this.lastCommand.Execute();
		
	}

}
