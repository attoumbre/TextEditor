package fr.istic.aco.editor.Caretaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recordable;

public class UndoManagerImpl implements UndoManager{

	private List<Pair<Recordable, Optional<Memento>>> pastStates;
	private List<Pair<Recordable, Optional<Memento>>> futurStates;
	
	private Boolean started ;
	
	public UndoManagerImpl() {
		pastStates = new ArrayList<>();
		futurStates = new ArrayList<>();
		
		
	}
	
	@Override
	public void store(Recordable cmd) {
		if(started) {
			pastStates.add(new Pair<>(cmd, cmd.getMemento()));
		}
		
	}

	@Override
	public void undo() {
		//engine.reset();
		futurStates.add(pastStates.get(pastStates.size()-1));
		
		pastStates.remove(pastStates.size()-1);
		
		pastStates.forEach(p -> {
			if(p.getM().isPresent()) {
				p.getR().setMemento(p.getM().get());
			}
			p.getR().execute(); 
		});
		
	}

	@Override
	public void redo() {
		
		//engine.reset();
		pastStates.add(futurStates.get(futurStates.size()-1));
		futurStates.remove(futurStates.size()-1);
		
		futurStates.forEach(p -> {
			if(p.getM().isPresent()) {
				p.getR().setMemento(p.getM().get());
			}
			p.getR().execute();
		});
	}

	@Override
	public void start() {
		started = true;
		
	}



	@Override
	public void stop() {
		started = false;
		
	}



	@Override
	public Boolean started() {
		
		return started;
	}

}
