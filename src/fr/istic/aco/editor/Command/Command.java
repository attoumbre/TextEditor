package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Memento.Originator;

public interface Command extends Originator{

	/**
	 * execution de la concreteCommand
	 */
	void execute();
	
	
}
