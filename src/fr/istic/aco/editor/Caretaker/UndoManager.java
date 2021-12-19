package fr.istic.aco.editor.Caretaker;

public interface UndoManager {

	void store();
	void undo();
	void redo();
}
