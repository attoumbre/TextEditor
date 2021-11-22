package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;

public class DeleteCommand implements Command{
	
	
	private Engine engine;
	
	
	
	public DeleteCommand(Engine engine) {
	
		this.engine=engine;
		
	}

	@Override
	public void Execute() {
		engine.delete();
		
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
