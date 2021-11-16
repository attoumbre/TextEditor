package fr.istic.aco.editor.Recorder;

import fr.istic.aco.editor.Command.Command;

public interface Recorder {

	/**
	 * methode permettant de save la derniere commande jouée
	 * 
	 */
	public Command save(Command c);
	
	/**
	 * methode permettant rejouer la derniere commande
	 * 
	 */
	public void replay();
}
