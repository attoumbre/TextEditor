package fr.istic.aco.editor.Recorder;

public interface Recorder extends Recordable{

	/**
	 * methode permettant de save la derniere commande jouée
	 *
	 *  @throws IllegalArgumentException si la command c est nulle 
	 */
	public void save(Recordable c);
	
	/**
	 * methode permettant rejouer la derniere commande
	 * 
	 */
	public void replay();
	
	/**
	 * met started à true pour debuter enregistrement
	 * 
	 */
	public void start();
	
	/**
	 * met started à false pour mettre fin à l'enregistrement
	 * 
	 */
	public void stop();
	
	/**
	 * true si l'enregistrement a débuté
	 * false pour l'arreter
	 * @return
	 */
	public Boolean started();
	
}
