package fr.istic.aco.editor.Recorder;

import fr.istic.aco.editor.Command.Command;
import fr.istic.aco.editor.Memento.Memento;

public class Pair {

	private Memento memento;
	private Command command;
	
	Pair(Command cmd, Memento mmt){
		command = cmd;
		memento = mmt;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	
}
