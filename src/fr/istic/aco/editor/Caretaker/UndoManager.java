package fr.istic.aco.editor.Caretaker;

import fr.istic.aco.editor.Recorder.Recordable;

public interface UndoManager {

	/**
	 * enregistre la commande jouée
	 * @param cmd
	 */
	public void store(Recordable cmd);
	
	/**
	 * jouer les commande sauf la derniere
	 */
	public void undo();
	
	/**
	 * jouer les commande 
	 */
	public void redo();
	
	public void start();
	public void stop();
	public Boolean started();
}
