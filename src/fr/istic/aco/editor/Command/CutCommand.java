package fr.istic.aco.editor.Command;

import java.util.Optional;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recorder;

public class CutCommand implements Command{

	private Engine engine;
	private Recorder recorder;
	
	
	
	public CutCommand(Engine engine, Recorder recoder) {
		this.engine = engine;
		this.recorder=  recoder;
		
	}
	
	@Override
	public void execute() {
		engine.cutSelectedText();
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
