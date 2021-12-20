package fr.istic.aco.editor.Invoker;

import java.util.Map;

import fr.istic.aco.editor.Command.Command;

public interface Invoker {

	/**
	 * Ajouter une commande a la liste des commandes
	 *@param c
	 *@param id
	 * @throws IllegalArgumentException si la command est nulle ou si l id est null
	 */
	void addCommand(Command c, String id);
	
	/**
	 * Ajouter une commande a la liste des commandes
	 *@param s
	 * @throws IllegalArgumentException si l'id est nulle 
	 */
	void playCommand(String s);
	
	/**
	 * retourner le text a inserer
	 * @return
	 */
	String getElement();
	
	/**
	 * modifier le text
	 * @param element
	 */
	void setElement( String element);
	
	/**
	 * retourner le text a inserer
	 * @return
	 */
	int getIndexB();
	
	/**
	 * modifier l'index de debut
	 * @param indexB
	 */
	void setIndexB(int indexB );
	
	/**
	 * retourner le text a inserer
	 * @return
	 */
	int getIndexF();
	
	/**
	 * modifier l'index de fin
	 * @param indexF
	 */
	void setIndexF(int indexF);

}
