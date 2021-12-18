package fr.istic.aco.editor.Memento;

public class InsertMemento implements Memento{
	
	private String text;
	
	public InsertMemento(String text) {
		this.text = text;
		
	}

	public void SetText(String text) {
		this.text = text; 
	
	}


	public String getText() {
		
		return text;
	}


}
