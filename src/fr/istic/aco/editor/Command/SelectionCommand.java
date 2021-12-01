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
		selection.setBeginIndex(invoker.getIndexB());
		selection.setEndIndex(invoker.getIndexF());
		//changer les index dans le memento
		getMemento().setIndexB(invoker.getIndexB());
		getMemento().setIndexF(invoker.getIndexF());
		
		
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
		this.memento = m;
		
	}
}
