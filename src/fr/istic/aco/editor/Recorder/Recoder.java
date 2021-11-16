package fr.istic.aco.editor.Recorder;


import fr.istic.aco.editor.Command.Command;

public interface Recoder {

	Command recoderSave(Command c);
	
    void recoderReplay();
}