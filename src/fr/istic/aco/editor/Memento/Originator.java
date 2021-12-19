package fr.istic.aco.editor.Memento;

import java.util.Optional;

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
