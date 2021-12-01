package fr.istic.aco.editor.Recorder;

import java.util.ArrayList;
import java.util.List;

import fr.istic.aco.editor.Command.Command;
import fr.istic.aco.editor.Memento.Memento;
public class RecorderImpl implements Recorder {
	private List<Pair> listCommand;
	private Boolean started;

	public RecorderImpl() {
		this.listCommand = new ArrayList<Pair>();
		started = false;
	}
	
	

	@Override
	public void save(Command c) {
		
		//Lors de l'insertion on ajoute le text à inserer dans le memento "c" contient donc un memento
		if(started) {
			Memento memento = c.getMemento();
			Pair pair = new Pair(c,memento);
			listCommand.add(pair);
		}
		
		
		
	}
		

	@Override
	public void replay() {
		 if (!started) {
	            for (int i = 0; i < listCommand.size(); i++) {
	                Pair pair = listCommand.get(i);
	                //comment rejouer la commande??
	                pair.getCommand().execute(); //pas encore finis
	                
	            }
	        }

		
		
		
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
