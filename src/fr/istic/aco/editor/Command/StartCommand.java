package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Caretaker.UndoManager;
import fr.istic.aco.editor.Recorder.Recorder;

public class StartCommand implements Command {

	private Recorder recorder;
	private UndoManager undoManager;
	StartCommand(Recorder recorder, UndoManager undoManager){
		this.recorder = recorder;
		this.undoManager = undoManager;
	}
	
	
	@Override
	public void execute() {
		
		undoManager.start();
		recorder.start();
	}



}
