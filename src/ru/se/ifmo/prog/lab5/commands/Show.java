package ru.se.ifmo.prog.lab5.commands;

import ru.se.ifmo.prog.lab5.cores.*;

public class Show extends Command {
	public Show(CommandManager commandmanager, Console console) {
		super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении", 1, commandmanager, console);
	}
	@Override
	public void execute(String[] args) {
		super.check(args.length);
		console.printCollection();
	}
}
