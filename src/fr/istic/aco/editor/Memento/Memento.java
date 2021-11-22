package fr.istic.aco.editor.Memento;

public interface Memento {

	
	/**
	 * Modifier le text du memento
	 */
	void SetText(String text);
	
	/**
	 * recuperer le text du memento
	 */
	String getText();
	
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
