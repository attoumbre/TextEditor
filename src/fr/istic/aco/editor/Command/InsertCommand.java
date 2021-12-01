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
	
	
	public InsertCommand(Engine engine, Recorder recorder,Invoker invoker) {
		this.engine = engine;
		this.recorder = recorder;
		this.invoker = invoker;
		memento = new InsertMemento();
	}

	/**
	 * inserer un string
	 */
	@Override
	public void execute() {
		String element = invoker.getElement();
		engine.insert(element);
		//memento met a jour le text
		memento.SetText(element);
		//recorder save la commande cela nous evite de faire une concrete commande save
		recorder.save(this);
	}
	
	

	@Override
	public Memento getMemento() {
		
		return memento;
	}

	@Override
	public Engine getEngine() {
		
		return engine;
	}

	@Override
	public void setMemento(Memento m) {
		// TODO Auto-generated method stub
		
	}

}
