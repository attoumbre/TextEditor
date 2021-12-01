package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Invoker.Invoker;
import fr.istic.aco.editor.Memento.InsertMemento;
import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recorder;

public class InsertCommand implements Command{
	
	private Engine engine;
	private Invoker invoker;
	private Recorder recorder;
	private Memento memento;
	String element;
	
	
	public InsertCommand(Engine engine, Recorder recorder,Invoker invoker, InsertMemento memento) {
		this.engine = engine;
		this.recorder = recorder;
		this.invoker = invoker;
		this.memento = memento;
	}

	/**
	 * inserer un string
	 */
	@Override
	public void execute() {
		this.element = invoker.getElement();
		this.engine.insert(element);
		//recorder save la commande cela nous evite de faire une concrete commande save
		recorder.save(this);
		//memento met a jour le text
		setMemento(this.memento);
		
	}
	
	

	@Override
	public Memento getMemento() {
		
		return this.memento;
	}

	@Override
	public Engine getEngine() {
		
		return this.engine;
	}

	@Override
	public void setMemento(Memento m) {
		
		m.SetText(element);
	}

}
