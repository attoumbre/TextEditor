package fr.istic.aco.editor.Command;

import java.util.Optional;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Recorder.Recorder;

public class StartCommand implements Command {

	private Recorder recorder;
	StartCommand(Recorder recorder){
		this.recorder = recorder;
	}
	
	
	@Override
	public void execute() {

		recorder.start();
		
	}


	@Override
	public Optional<Memento> getMemento() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setMemento(Memento m) {
		// TODO Auto-generated method stub
		
	}


}
