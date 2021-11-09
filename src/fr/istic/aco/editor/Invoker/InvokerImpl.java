package fr.istic.aco.editor.Invoker;

import java.util.HashMap;
import java.util.Map;

import fr.istic.aco.editor.Command.Command;

public class InvokerImpl implements Invoker{

	private Map<String, Command> map= new HashMap<String, Command>();
	private String element;


	@Override
	public void addCommand(Command c, String id) {
		// l'id ou la commande ne peuvent pas etre null
		if(id!=null & c!= null) {
			//ajouter au map
			map.put(id, c);
		}
		
	}

	
	@Override
	public void playCommand(String s) {
		// recuperation de la commande
		Command c= map.get(s);
	
		//lancer la commande
		c.Execute();
	}
	
	public String getElement() {
		return element;
	}


	public void setElement(String element) {
		this.element = element;
	}


}
