package fr.istic.aco.editor.Invoker;

import fr.istic.aco.editor.Command.Command;

public interface Invoker {
	/**
	 * Ajouter une commande a la liste des commandes
	 *
	 * @throws nullPointerException si la command est nulle ou si l id est null
	 */
	void addCommand(Command c, String id);
	
	/**
	 * Ajouter une commande a la liste des commandes
	 *
	 * @throws nullPointerException si l'id est nulle 
	 */
	void playCommand(String s);

}
