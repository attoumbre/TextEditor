package fr.istic.aco.editor.Memento;


public class SelectionMemento implements Memento{

	private int indexB;
	private int indexF;
	
	public SelectionMemento(int indexB, int indexF) {
		this.indexB = indexB;
		this.indexF = indexF;
	}
	

	public int getIndexB() {
		
		return indexB;
	}


	public void setIndexB(int indexB) {
		this.indexB = indexB;
		
	}


	public int getIndexF() {
		
		return indexF;
	}


	public void setIndexF(int indexF) {
		this.indexF = indexF;

	}

}
