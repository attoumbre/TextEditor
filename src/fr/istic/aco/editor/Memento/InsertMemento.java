package fr.istic.aco.editor.Memento;

public class InsertMemento implements Memento{
	
	private String text;

	@Override
	public void SetText(String text) {
		this.text = text; 
		
	}

	@Override
	public String getText() {
		
		return text;
	}

	@Override
	public int getIndexB() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setIndexB(int indexB) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIndexF() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setIndexF(int indexF) {
		// TODO Auto-generated method stub
		
	}

}
