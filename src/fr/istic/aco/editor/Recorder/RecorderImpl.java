package fr.istic.aco.editor.Recorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.istic.aco.editor.Command.Command;
import fr.istic.aco.editor.Memento.Memento;
public class RecorderImpl implements Recorder {
	
	private List<Pair<Recordable, Optional<Memento>>> listCommand;
	private Boolean started;
	
	public RecorderImpl() {
		this.listCommand = new ArrayList<>();
	
	}
	
	

	@Override
	public void save(Command c) {
		
		if(started) {
			if(c==null) {
				throw new IllegalArgumentException("command ne peut etre null");
			}
			
			listCommand.add(new Pair<>(c, c.getMemento()));
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
