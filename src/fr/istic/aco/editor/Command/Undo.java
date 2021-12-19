package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Caretaker.UndoManager;

public class Undo implements Command{

	private UndoManager undoManager;
	
	public Undo(UndoManager undoManager) {
		this.undoManager = undoManager;
	}
	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		undoManager.undo();
	}

}
