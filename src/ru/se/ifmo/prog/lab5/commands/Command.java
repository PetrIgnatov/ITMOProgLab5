package ru.se.ifmo.prog.lab5.commands;

import ru.se.ifmo.prog.lab5.cores.*;

public abstract class Command implements Executable {
	String name;
	String description;
	CommandManager commandmanager;
	Console console;
	CollectionData collectiondata;
	int argsnumber;
	String[] parametersAdvices;

	public Command(String name, String description, int argsnumber, CommandManager commandmanager, Console console) {
		this.name = name;
		this.description = description;
		this.commandmanager = commandmanager;
		this.console = console;
		this.argsnumber = argsnumber;
		this.collectiondata = null;
	}

	public Command(String name, String description, int argsnumber, CommandManager commandmanager, Console console, CollectionData collectiondata) {
		this.name = name;
		this.description = description;
		this.commandmanager = commandmanager;
		this.console = console;
		this.argsnumber = argsnumber;
		this.collectiondata = collectiondata;
	}

	public Command(String name, String description, int argsnumber, CommandManager commandmanager, Console console, CollectionData collectiondata, String[] parametersAdvices) {
		this.name = name;
		this.description = description;
		this.commandmanager = commandmanager;
		this.console = console;
		this.argsnumber = argsnumber;
		this.collectiondata = collectiondata;
		this.parametersAdvices = parametersAdvices;
	}

	public void check(int argsnumber) {
		if (this.argsnumber != argsnumber) {
			throw new IllegalArgumentException("Error! Got " + Integer.valueOf(argsnumber-1) + " arguments when " + Integer.valueOf(this.argsnumber-1) + " needed");
		}
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String getDescription() {
		return description;
	}
}
