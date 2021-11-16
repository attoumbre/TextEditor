package fr.istic.aco.editor.Command;

import fr.istic.aco.editor.Receiver.Engine;

public class CopyCommand implements Command{
	
	private Engine engine;
	
	
	public CopyCommand(Engine engine) {
		this.engine=engine;
		
	}
	@Override
	public void Execute() {
		//à traiter command à executer, l'invoker donné la commande a executer 
		//Command c = this.invoker.playCommand("copier");
		//executer la commande via engine qui sait qui peut l'executer
		engine.copySelectedText();
		
	}

}
