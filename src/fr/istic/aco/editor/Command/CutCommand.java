package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;

public class CutCommand implements Command{

	private Engine engine;
	
	
	
	
	public CutCommand(Engine engine) {
		this.engine = engine;
		
		
	}
	
	@Override
	public void execute() {
		engine.cutSelectedText();
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
