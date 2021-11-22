package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;

public class CopyCommand implements Command{
	
	private Engine engine;
	
	
	
	
	public CopyCommand(Engine engine) {
		this.engine = engine;
		
	}
	
	@Override
	public void Execute() {
		//executer la commande via engine qui sait qui peut l'executer
		engine.copySelectedText();
		
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
