package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;

public interface Command {

	/**
	 * execution de la concreteCommand
	 */
	void execute();
	
	/**
	 * retourner le memento 
	 * @return
	 */
	Memento getMemento();
	
	/**
	 * retourner l'engine
	 * @return
	 */
	Engine getEngine();
}
