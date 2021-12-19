package fr.istic.aco.editor.Memento;

public class EditorMemento implements Memento{

	String texte;
	int beginIndex;
	int endIndex;
	public EditorMemento(String texte,int beginIndex,int endIndex) {
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
		this.texte = texte;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
}
