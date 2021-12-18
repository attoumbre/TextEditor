package fr.istic.aco.editor.Command;

import java.util.Optional;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recorder;

public class DeleteCommand implements Command{
	
	
	private Engine engine;
	private Recorder recorder;
	
	
	
	public DeleteCommand(Engine engine, Recorder recorder) {
	
		this.engine=engine;
		this.recorder= recorder;
	}

	@Override
	public void execute() {
		engine.delete();
		recorder.save(this);
	}

	@Override
	public Optional <Memento> getMemento() {
		
		return Optional.empty();
	}

	@Override
	public Engine getEngine() {
		
		return engine;
	}

	@Override
	public void setMemento(Memento m) {
		
		
	}

}
