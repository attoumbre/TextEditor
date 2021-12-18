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
		
		if(started) {
			if(c==null) {
				throw new IllegalArgumentException("command ne peut etre null");
			}
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
	                //comment rejouer la commande?? avec des if peut etre
	                //avoir le memento de la paire
	                Memento memento = pair.getMemento();
	                if(memento == null) {
	                	//executer les commande 
		                pair.getCommand().execute();
	                }else {
	                	 //modifier ou restaurer le memento (en executant la commande on la save il faut save le memento aussi
		                pair.getCommand().setMemento(memento);
		                //à quel moment on utilise les elements du memento pour faire l'execution de la commande??
		                //executer les commande 
		                pair.getCommand().execute(); //pas encore finis
	                }
	               
	                
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
