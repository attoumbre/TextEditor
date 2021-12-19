package fr.istic.aco.editor.Command;

import java.util.Optional;

import fr.istic.aco.editor.Caretaker.UndoManager;
import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recordable;
import fr.istic.aco.editor.Recorder.Recorder;

public class DeleteCommand implements Recordable{
	
	
	private Engine engine;
	private Recorder recorder;
	private UndoManager undoManager;
	
	
	public DeleteCommand(Engine engine, Recorder recorder, UndoManager undoManager) {
		this.undoManager = undoManager;
	
		this.engine=engine;
		this.recorder= recorder;
	}

	@Override
	public void execute() {
		undoManager.store(this);
		engine.delete();
		recorder.save(this);
	}

	@Override
	public Optional <Memento> getMemento() {
		
		return Optional.empty();
	}

	
	@Override
	public void setMemento(Memento m) {
		
		
	}

}
