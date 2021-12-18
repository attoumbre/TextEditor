package fr.istic.aco.editor.Command;

import java.util.Optional;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recorder;

public class ReplayCommand implements Command {

	private Recorder recoder;
	
	
	public ReplayCommand (Recorder recorder) {
		this.recoder = recorder;
	}
	
	@Override
	public void execute() {
		this.recoder.replay();
		this.recoder.save(this);
	}

	@Override
	public Optional <Memento> getMemento() {
		
		return Optional.empty();
	}

	@Override
	public Engine getEngine() {
		
		return null;
	}

	@Override
	public void setMemento(Memento m) {
		// TODO Auto-generated method stub
		
	}

}
