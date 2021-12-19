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
			if(c==null) {
				throw new IllegalArgumentException("command ne peut etre null");
			}
			
			listCommand.add(new Pair<>(c, c.getMemento()));
		}
		
	}
		

	@Override
	public void replay() {
	
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



	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Optional<Memento> getMemento() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void setMemento(Memento m) {
		// TODO Auto-generated method stub
		
	}

}
