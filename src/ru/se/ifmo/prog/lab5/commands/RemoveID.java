package ru.se.ifmo.prog.lab5.commands;

import ru.se.ifmo.prog.lab5.cores.*;

public class RemoveID extends Command {
	public RemoveID(CommandManager commandmanager, Console console, CollectionData collectiondata) {
		super("remove_by_id id", "удалить элемент из коллекции по его id", 2, commandmanager, console, collectiondata);
	}
	@Override
	public void execute(String[] args) {
		super.check(args.length);
		try {
			Integer.parseInt(args[1]);
		}
		catch (Exception e) {
			System.out.println("Error! Argument is not a number");
			return;
		}
		collectiondata.remove(Integer.parseInt(args[1]));
	}
}
