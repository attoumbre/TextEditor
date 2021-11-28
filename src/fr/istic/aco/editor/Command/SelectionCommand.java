package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Invoker.Invoker;
import fr.istic.aco.editor.Memento.InsertMemento;
import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Receiver.Selection;
import fr.istic.aco.editor.Recorder.Recorder;

public class SelectionCommand implements Command{

	private Engine engine;
	private Invoker invoker;
	private Memento memento;
	private Recorder recorder;
	
	public SelectionCommand(Engine engine,Recorder recorder, Invoker invoker) {
		this.engine=engine;
		this.recorder = recorder;
		this.invoker=invoker;
		this.memento = new InsertMemento();
		
	}
	
	@Override
	public void execute() {
		
		
		Selection selection=engine.getSelection();
		
		selection.setEndIndex(invoker.getIndexF());
		selection.setBeginIndex(invoker.getIndexB());
		
		getMemento().setIndexF(invoker.getIndexF());
		getMemento().setIndexB(invoker.getIndexB());
		
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
}
