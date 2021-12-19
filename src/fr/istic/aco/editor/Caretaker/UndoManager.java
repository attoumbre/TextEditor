package fr.istic.aco.editor.Caretaker;

import fr.istic.aco.editor.Recorder.Recordable;

public interface UndoManager {

	void store(Recordable cmd);
	void undo();
	void redo();
}
