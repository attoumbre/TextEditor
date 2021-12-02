package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recorder;

public class StopCommand implements Command{

	private Recorder recorder;
	StopCommand(Recorder recorder){
		this.recorder= recorder;
	}
	
	@Override
	public void execute() {

		recorder.stop();
		
	}

	@Override
	public Memento getMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMemento(Memento m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Engine getEngine() {
		// TODO Auto-generated method stub
		return null;
	}

}
