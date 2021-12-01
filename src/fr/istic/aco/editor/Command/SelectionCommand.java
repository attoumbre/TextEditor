package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Invoker.Invoker;
import fr.istic.aco.editor.Memento.SelectionMemento;
import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Receiver.Selection;
import fr.istic.aco.editor.Recorder.Recorder;

public class SelectionCommand implements Command{

	private Engine engine;
	private Invoker invoker;
	private Memento memento;
	private Recorder recorder;
	
	
	public SelectionCommand(Engine engine,Recorder recorder, Invoker invoker,SelectionMemento memento) {
		this.engine=engine;
		this.recorder = recorder;
		this.invoker=invoker;
		this.memento = memento;	
	}
	
	@Override
	public void execute() {
		
		
		Selection selection=engine.getSelection();
		selection.setBeginIndex(invoker.getIndexB());
		selection.setEndIndex(invoker.getIndexF());
		this.recorder.save(this);
		recorder.save(this);
		//changer les index dans le memento
		setMemento(memento);

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
		m.setIndexB(invoker.getIndexB());
		m.setIndexF(invoker.getIndexF());
		
	}
}
