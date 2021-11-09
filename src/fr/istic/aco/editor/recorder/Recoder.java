package fr.istic.aco.editor.recorder;


import fr.istic.aco.editor.command.Command;

public interface Recoder {

	Command recoderSave(Command c);
	
    void recoderReplay();
}