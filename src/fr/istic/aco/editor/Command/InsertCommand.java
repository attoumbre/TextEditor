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
	
	String element;
	
	
	public InsertCommand(Engine engine, Recorder recorder,Invoker invoker) {
		this.engine = engine;
		this.recorder = recorder;
		this.invoker = invoker;
		
	}

	/**
	 * inserer un string
	 */
	@Override
	public void execute() {
		
		if(invoker==null) {
			this.element = getMemento().getText();
		}else {
			this.element = invoker.getElement();
		}
		this.engine.insert(element);
		//recorder save la commande cela nous evite de faire une concrete commande save
		recorder.save(this);
		
		
	}
	
	

	@Override
	public Memento getMemento() {
		Memento memento = new InsertMemento(element);
		return memento;
	}

	@Override
	public Engine getEngine() {
		
		return this.engine;
	}

	@Override
	public void setMemento(Memento m) {
		if(m != null) {
			m.SetText(element);
		}
		
	}

}
