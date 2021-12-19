package fr.istic.aco.editor.Recorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.istic.aco.editor.Memento.Memento;
public class RecorderImpl implements Recorder {
	
	private List<Pair<Recordable, Optional<Memento>>> listCommand;
	private Boolean started;
	
	public RecorderImpl() {
		this.listCommand = new ArrayList<>();
	
	}
	
	

	@Override
	public void save(Recordable c) {
		
		if(started) {

			listCommand.add(new Pair<>(c, c.getMemento()));
		}
		
	}
		

	@Override
	public void replay() {

		listCommand.forEach(pair -> {
			if(pair.getM().isPresent()) {
				pair.getR().setMemento(pair.getM().get());
			}
			pair.getR().execute();
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
