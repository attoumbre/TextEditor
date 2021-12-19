package fr.istic.aco.editor.Recorder;

public interface Recorder extends Recordable{

	/**
	 * methode permettant de save la derniere commande jou�e
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
	 * met started � true pour debuter enregistrement
	 * 
	 */
	public void start();
	
	/**
	 * met started � false pour mettre fin � l'enregistrement
	 * 
	 */
	public void stop();
	
	/**
	 * true si l'enregistrement a d�but�
	 * false pour l'arreter
	 * @return
	 */
	public Boolean started();
	
}
