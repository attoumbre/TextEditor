package fr.istic.aco.editor.Caretaker;

import fr.istic.aco.editor.Recorder.Recordable;

public interface UndoManager {

	/**
	 * enregistre la commande jouée
	 * @param cmd
	 */
	void store(Recordable cmd);
	
	/**
	 * jouer les commande sauf la derniere
	 */
	void undo();
	
	/**
	 * jouer les commande 
	 */
	void redo();
	
	void start();
	void stop();
	Boolean started();
}
