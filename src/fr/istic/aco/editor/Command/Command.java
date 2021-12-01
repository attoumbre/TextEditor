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
	 * 
	 * modifiie le memento
	 */
	void setMemento(Memento m);
	
	/**
	 * retourner l'engine
	 * @return
	 */
	Engine getEngine();
}
