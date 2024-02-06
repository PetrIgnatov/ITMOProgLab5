package ru.se.ifmo.prog.lab5.commands;

import ru.se.ifmo.prog.lab5.cores.*;

public class Clear extends Command {
	public Clear(CommandManager commandmanager, Console console, CollectionData collectiondata) {
		super("clear", "очистить коллекцию", 1, commandmanager, console, collectiondata);
	}
	@Override
	public void execute(String[] args) {
		super.check(args.length);
		collectiondata.clear();
	}
}
