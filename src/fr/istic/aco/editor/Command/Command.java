package fr.istic.aco.editor.Command;

import java.util.Optional;

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
	Optional <Memento> getMemento();
	
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
