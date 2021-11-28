package fr.istic.aco.editor.Invoker;

import java.util.HashMap;
import java.util.Map;

import fr.istic.aco.editor.Command.Command;

public class InvokerImpl implements Invoker{

	private Map<String, Command> map;
	private String element;
	
	private int indexB;
	private int indexF;
	
	

	public InvokerImpl(){
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
			throw new IllegalArgumentException("Commande ou identifiant de commande est nulle");
		}
		
	}

	
	@Override
	public void playCommand(String s) {
		
		// recuperation de la commande*
		if(s!=null) {
			//recuperer la commande
			Command c= map.get(s);
			
			//lancer la commande
			c.execute();
		}else {
			throw new IllegalArgumentException("Commande ou identifiant de commande est nulle");
		}
	}
	
	@Override
	public String getElement() {
		
		return element;
	}

	@Override
	public void setElement(String element) {
		if(element != null) {
			this.element = element;
		}else {
			throw new NullPointerException("aucun element fourni ");
		}
		
	}

	@Override
	public int getIndexB() {
		return indexB;
	}
	
	@Override
	public void setIndexB(int indexB) {
		this.indexB = indexB;
	}

	@Override
	public int getIndexF() {
		return indexF;
	}

	@Override
	public void setIndexF(int indexF) {
		this.indexF = indexF;
	}

}
