package fr.istic.aco.editor.Command;

import java.util.Optional;

import fr.istic.aco.editor.Invoker.Invoker;
import fr.istic.aco.editor.Memento.InsertMemento;
import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recordable;
import fr.istic.aco.editor.Recorder.Recorder;

public class InsertCommand implements Recordable{
	
	private Engine engine;
	private Invoker invoker;
	private Recorder recorder;
	private Boolean isRestore = false;
	private String element;
	
	
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
		
		if(!isRestore) {
			element = invoker.getElement();	
		}
		
		this.engine.insert(element);
		//recorder save la commande cela nous evite de faire une concrete commande save
		recorder.save(this);
		isRestore = false;
		
	}
	
	

	@Override
	public Optional<Memento> getMemento() {
		return Optional.of(new InsertMemento(element));
	}



	@Override
	public void setMemento(Memento m) {
		if(m == null) { throw new IllegalArgumentException();}
		element = ((InsertMemento) m).getText();
		isRestore = true;
	}

}
