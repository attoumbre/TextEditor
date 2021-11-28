package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;

public class PastCommand implements Command{

	private Engine engine;

	
	public PastCommand(Engine engine) {
		this.engine = engine;
		
	}
	
	@Override
	public void execute() {
		engine.pasteClipboard();
		
	}

	@Override
	public Memento getMemento() {
		
		return null;
	}

	@Override
	public Engine getEngine() {
		
		return engine;
	}

}
