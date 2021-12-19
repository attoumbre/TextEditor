package fr.istic.aco.editor.Command;

import java.util.Optional;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recordable;
import fr.istic.aco.editor.Recorder.Recorder;

public class PastCommand implements Recordable{

	private Engine engine;
	private Recorder recorder;
	
	public PastCommand(Engine engine , Recorder recorder) {
		this.engine=engine;
		this.recorder=recorder;
	}
	
	@Override
	public void execute() {
		engine.pasteClipboard();
		recorder.save(this);
	}

	@Override
	public Optional <Memento> getMemento() {
		
		return Optional.empty();
	}

	

	@Override
	public void setMemento(Memento m) {
		
		
	}

}
