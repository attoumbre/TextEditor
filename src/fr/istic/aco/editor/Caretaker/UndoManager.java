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
	
	/**
	 * pour modifier la variable started à true ce qui permet de commencer la sauvegarde de la commande
	 */
	public void start();
	
	/**
	 * pour modifier la variable started à false ce qui permet d'arreter une sauvegarde
	 */
	public void stop();
	
	/**
	 * la variable qui permet de 
	 * @return true si la commande start lancée sinon false
	 */
	public Boolean started();
}
