package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Caretaker.UndoManager;

public class Redo implements Command{


	
	private UndoManager undoManager;
	public Redo(UndoManager undoManager) {
		this.undoManager = undoManager;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		undoManager.redo();
	}

}
