package fr.istic.aco.editor.Memento;

public interface Memento {
	/**
	 *sauvegarde un texte
	 *
	 * @throws nullPointerException si le texe est null
	 */
	public void setText(String A);
	
	/**
	 *retourne le texte sauvegarde
	 *
	 * 
	 */
	public String getText();
}
