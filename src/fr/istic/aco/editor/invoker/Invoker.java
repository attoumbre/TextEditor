package fr.istic.aco.editor.invoker;

import fr.istic.aco.editor.command.Command;

public interface Invoker {

	void playCommand(String s);

	void addCommand(Command c, String id);

}
