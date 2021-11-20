package fr.istic.aco.editor.Command;


import fr.istic.aco.editor.Invoker.InvokerImpl;
import fr.istic.aco.editor.Memento.SelectionMemento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Receiver.Selection;
import fr.istic.aco.editor.Recorder.Recorder;

public class SelectionCommand implements Command{

	private Engine engine;
	private InvokerImpl invoker;
	private Recorder recorder;
	private SelectionMemento memento;
	private Selection selection;
	
	public SelectionCommand(Engine engine, InvokerImpl invoker, Recorder recorder, SelectionMemento memento) {
		this.engine=engine;
		this.invoker=invoker;
		this.recorder= recorder;
		this.memento=memento;
	}
	
	@Override
	public void Execute() {
		this.selection=engine.getSelection();
		this.selection.setEndIndex(invoker.getIndexF());
		this.selection.setBeginIndex(invoker.getIndexB());
		this.recorder.save(SelectionCommand.this);
		setMemento(memento);
	}
	
	public SelectionMemento getMemento() {
		return  this.memento;
	}
	
	public void setMemento(SelectionMemento m ) {
		m.setValue(this.selection);
		
	}
}
