package ru.se.ifmo.prog.lab5.commands;

import ru.se.ifmo.prog.lab5.cores.*;

public class RemoveIndex extends Command {
	public RemoveIndex(CommandManager commandmanager, Console console, CollectionData collectiondata) {
		super("remove_at index", "удалить элемент, находящийся в заданной позиции коллекции (index)", 2, commandmanager, console, collectiondata);
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
		collectiondata.removeIndex(Integer.parseInt(args[1]));
	}
}
