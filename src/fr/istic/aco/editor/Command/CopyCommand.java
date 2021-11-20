package fr.istic.aco.editor.Command;



import fr.istic.aco.editor.Receiver.Engine;
import fr.istic.aco.editor.Recorder.Recorder;

public class CopyCommand implements Command{
	
	private Engine engine;
	private Recorder recorder;
	
	
	public CopyCommand(Engine engine, Recorder recorder) {
		this.engine=engine;
		this.recorder= recorder;
		
	}
	@Override
	public void Execute() {
		//à traiter command à executer, l'invoker donné la commande a executer 
		//Command c = this.invoker.playCommand("copier");
		//executer la commande via engine qui sait qui peut l'executer
		engine.copySelectedText();
		recorder.save(CopyCommand.this);
		
	}

}
