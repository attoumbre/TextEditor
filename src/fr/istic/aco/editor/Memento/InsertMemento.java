package fr.istic.aco.editor.Memento;

public class InsertMemento implements Memento {

	 private Object saveState;
	 
	 
	 public InsertMemento() {
		 this.saveState="";
	 }
	 
	@Override
	public void setValue(Object A) {
		this.saveState= A;

	}

	@Override
	public Object getValue() {
		return  this.saveState;
	}

}
