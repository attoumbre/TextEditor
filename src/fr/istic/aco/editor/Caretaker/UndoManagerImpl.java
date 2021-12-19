package fr.istic.aco.editor.Caretaker;

import java.util.List;

import fr.istic.aco.editor.Memento.EditorMemento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recordable;

public class UndoManagerImpl implements UndoManager{

	List<EditorMemento> pastStates;
	List<EditorMemento> futurStates;
	Engine engine;
	
	

	@Override
	public void undo() {
		
		
	}

	@Override
	public void redo() {
		
	}

	@Override
	public void store(Recordable cmd) {
		// TODO Auto-generated method stub
		
	}

}
