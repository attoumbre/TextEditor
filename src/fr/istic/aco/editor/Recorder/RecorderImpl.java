package fr.istic.aco.editor.Recorder;

import java.util.ArrayList;
import java.util.List;

import fr.istic.aco.editor.Command.Command;
public class RecorderImpl implements Recorder {
	private List<Command> listCommand;

	public RecorderImpl() {
		this.listCommand = new ArrayList<Command>();
	}
	
	

	@Override
	public void save(Command c) {
		
		//Lors de l'insertion on ajoute le text à inserer dans le memento "c" contient donc un memento 
		listCommand.add(c);
		
		
	}
		

	@Override
	public void replay() {
		//replay que la derniere commande 
		Command command= listCommand.get(listCommand.size()-1);
		//trouver la condition pour jouer la derniere commande (insert ou selection)
		
		if(command.getMemento().getText()==null) {
			//int bindex=0;
			//int eindex=0;
			
			command.getEngine().getSelection().setEndIndex(command.getMemento().getIndexF());
			command.getEngine().getSelection().setBeginIndex(command.getMemento().getIndexB());
			//bindex=command.getEngine().getSelection().getBeginIndex();
			//eindex=command.getEngine().getSelection().getEndIndex();

		}else {
			//String text="";
			//command.getEngine().getSelection().setBeginIndex(command.getEngine().getSelection().getEndIndex());
			command.getEngine().insert(command.getMemento().getText());
			//text= command.getEngine().getBufferContents();
		}
		
		
		
	}



	@Override
	public Boolean Start() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean Stop() {
		// TODO Auto-generated method stub
		return null;
	}

}
