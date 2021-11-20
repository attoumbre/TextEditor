package fr.istic.aco.editor.Memento;

public class SelectionMemento implements Memento {

	private Object a;
	
	 public SelectionMemento() {
		this.a= "";
	}
	
	@Override
	public void setValue(Object A) {
		this.a =A;

	}

	@Override
	public Object getValue() {
		
		return this.a;
	}

}
