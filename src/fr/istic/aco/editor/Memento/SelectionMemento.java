package fr.istic.aco.editor.Memento;

public class SelectionMemento implements Memento{

	private int indexB;
	private int indexF;
	@Override
	public void SetText(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndexB() {
		
		return indexB;
	}

	@Override
	public void setIndexB(int indexB) {
		this.indexB = indexB;
		
	}

	@Override
	public int getIndexF() {
		
		return indexF;
	}

	@Override
	public void setIndexF(int indexF) {
		this.indexF = indexF;
	}

}
