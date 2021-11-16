package fr.istic.aco.editor.Invoker;

import java.util.HashMap;
import java.util.Map;

import fr.istic.aco.editor.Command.Command;

public class InvokerImpl implements Invoker{

	private Map<String, Command> map;
	private String element;
	
	private int indexB;
	private int indexF;
	
	

	InvokerImpl(){
		this.indexB=0;
		this.indexF=0;
		map= new HashMap<String, Command>();
		element="";
	}



	@Override
	public void addCommand(Command c, String id) {
		// l'id ou la commande ne peuvent pas etre null
		if(id!=null & c!= null) {
			//ajouter au map
			map.put(id, c);
		}else {
			throw new NullPointerException("Commande ou identifiant de commande est nulle");
		}
		
	}

	
	@Override
	public void playCommand(String s) {
		
		// recuperation de la commande*
		if(s!=null) {
			//recuperer la commande
			Command c= map.get(s);
			
			//lancer la commande
			c.Execute();
		}else {
			throw new NullPointerException("Commande ou identifiant de commande est nulle");
		}
	}
	
	public String getElement() {
		return element;
	}


	public void setElement(String element) {
		this.element = element;
	}

	
	public int getIndexB() {
		return indexB;
	}

	public void setIndexB(int indexB) {
		this.indexB = indexB;
	}

	public int getIndexF() {
		return indexF;
	}

	public void setIndexF(int indexF) {
		this.indexF = indexF;
	}

}
