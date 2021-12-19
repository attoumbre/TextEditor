package fr.istic.aco.editor.Command;

import java.util.Optional;

import fr.istic.aco.editor.Memento.Memento;

public interface Originator {


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
}
