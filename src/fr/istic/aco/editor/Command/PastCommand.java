package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recorder;

public class PastCommand implements Command{

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
	public Memento getMemento() {
		
		return null;
	}

	@Override
	public Engine getEngine() {
		
		return engine;
	}

	@Override
	public void setMemento(Memento m) {
		
		
	}

}
