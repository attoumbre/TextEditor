package fr.istic.aco.editor.Caretaker;

import java.util.List;
import java.util.Optional;

import fr.istic.aco.editor.Memento.Memento;
import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Receiver.EngineImpl;
import fr.istic.aco.editor.Recorder.Recordable;

public class UndoManagerImpl implements UndoManager{

	private List<Pair<Recordable, Optional<Memento>>> pastStates;
	private List<Pair<Recordable, Optional<Memento>>> futurStates;
	Engine engine = new EngineImpl();
	
	@Override
	public void store(Recordable cmd) {
		pastStates.add(new Pair<>(cmd, cmd.getMemento()));
	}

	@Override
	public void undo() {
		engine.reset();
		futurStates.add(pastStates.get(pastStates.size()-1));
		pastStates.remove(pastStates.size()-1);
		pastStates.forEach(pair -> {
			if(pair.getM().isPresent()) {
				pair.getR().setMemento(pair.getM().get());
			}
			pair.getR().execute();
		});
		
	}

	@Override
	public void redo() {
		
		engine.reset();
		pastStates.add(futurStates.get(futurStates.size()-1));
		futurStates.remove(futurStates.size()-1);
		futurStates.forEach(pair -> {
			if(pair.getM().isPresent()) {
				pair.getR().setMemento(pair.getM().get());
			}
			pair.getR().execute();
		});
	}

	

}
