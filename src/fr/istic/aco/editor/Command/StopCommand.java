package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Caretaker.UndoManager;
import fr.istic.aco.editor.Recorder.Recorder;

public class StopCommand implements Command{

	private Recorder recorder;
	private UndoManager undoManager;
	
	StopCommand(Recorder recorder, UndoManager undoManager){
		this.recorder= recorder;
		this.undoManager = undoManager;
	}
	
	@Override
	public void execute() {

		recorder.stop();
		undoManager.start();
	}


	
}
