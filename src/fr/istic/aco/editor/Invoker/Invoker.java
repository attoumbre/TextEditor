package fr.istic.aco.editor.Invoker;

import fr.istic.aco.editor.Command.Command;

public interface Invoker {
	void addCommand(Command c, String id);
	void playCommand(String s);

}
