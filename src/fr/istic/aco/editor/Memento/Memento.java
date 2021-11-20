package fr.istic.aco.editor.Memento;

public interface Memento {
	/**
	 *sauvegarde un texte
	 *
	 * @throws nullPointerException si l'objet est null
	 */
	public void setValue(Object A);
	
	/**
	 *retourne le texte sauvegarde
	 *
	 */
	public Object getValue();
}
