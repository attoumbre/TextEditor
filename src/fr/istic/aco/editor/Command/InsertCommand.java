package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Invoker.InvokerImpl;
import fr.istic.aco.editor.Memento.InsertMemento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recorder;

public class InsertCommand implements Command{
	String element ;
	private Engine engine;
	private InvokerImpl invoker;
	private Recorder recorder;
	private InsertMemento memento;
	
	public InsertCommand(Engine engine, InvokerImpl invoker, Recorder recorder, InsertMemento memento) {
		this.engine= engine;
		this.invoker=invoker;
		this.recorder= recorder;
		this.memento= memento;
	}

	/**
	 * inserer un string
	 */
	@Override
	public void Execute() {
		this.element = invoker.getElement();
		this.engine.insert(element);
		this.recorder.save(InsertCommand.this);
		setMemento(memento);
	}

	public InsertMemento getMemento() {
	  return this.memento;
	}
	
	public void setMemento(InsertMemento m ) {
		m.setValue(element);
		
	}
}
