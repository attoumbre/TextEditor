package fr.istic.aco.editor.Command;

import java.util.Optional;

import fr.istic.aco.editor.Invoker.Invoker;
import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Memento.SelectionMemento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Receiver.Selection;
import fr.istic.aco.editor.Recorder.Recordable;
import fr.istic.aco.editor.Recorder.Recorder;

public class SelectionCommand implements Recordable{

	private Engine engine;
	private Invoker invoker;
	private Recorder recorder;
	private Boolean isRestore = false;
	private int IndexD;
	private int IndexF;
	
	
	public SelectionCommand(Engine engine,Recorder recorder, Invoker invoker) {
		this.engine=engine;
		this.recorder = recorder;
		this.invoker=invoker;
		
	}
	
	@Override
	public void execute() {
		
		if(!isRestore) {
			IndexD = invoker.getIndexB();	
			IndexF = invoker.getIndexF();
		}
		Selection selection=engine.getSelection();
		
		if (selection.getEndIndex() < IndexD) {
			selection.setEndIndex(IndexF);
			selection.setBeginIndex(IndexD);
		} else {
			selection.setBeginIndex(IndexD);
			selection.setEndIndex(IndexF);
		}
		
		
		
		recorder.save(this);
		isRestore = false;

	}

	@Override
	public Optional<Memento> getMemento() {
		return Optional.of(new SelectionMemento(IndexD,IndexF));
	}

	@Override
	public void setMemento(Memento m) {
		
		IndexD = ((SelectionMemento) m).getIndexB();
		IndexF = ((SelectionMemento) m).getIndexF();
		isRestore = true;
		
	}
}
