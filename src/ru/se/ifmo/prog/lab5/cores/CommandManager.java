package ru.se.ifmo.prog.lab5.cores;

import java.util.Map;
import java.util.HashMap;
import ru.se.ifmo.prog.lab5.commands.*;

public class CommandManager {
	private HashMap<String, Command> commandList;
	
	public CommandManager() {
		this.commandList = new HashMap<String, Command>();	
	}
	
	public CommandManager(HashMap<String, Command> commandList) {
		this.commandList = commandList;
	}

	public void createCommand(String name, Command command) {
		if (name.equals(null) || name.equals("^\s*$")) {
			throw new IllegalArgumentException("Error! Can't create command with name \"" + name + "\"");
		}
		commandList.put(name, command);
	}

	public String getCommands() {
		String commands = "";
		for (Map.Entry<String, Command> val : commandList.entrySet()) {
			commands += val.getValue().getName() + " : " + val.getValue().getDescription() + "\n";
		}
		return commands;
	}

	public Command getCommand(String name) {
		if (commandList.containsKey(name)) {
			return commandList.get(name);
		}
		throw new IllegalArgumentException("Error! Unknown command \"" + name + "\"");
	}
}

