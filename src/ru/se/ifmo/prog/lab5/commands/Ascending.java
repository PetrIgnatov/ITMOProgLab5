package ru.se.ifmo.prog.lab5.commands;

import ru.se.ifmo.prog.lab5.cores.*;

public class Ascending extends Command {
	public Ascending(CommandManager commandmanager, Console console, CollectionData collectiondata) {
		super("print_field_ascending_character", "вывести значения поля character всех элементов в порядке возрастания", 1, commandmanager, console, collectiondata);
	}
	@Override
	public void execute(String[] args) {
		super.check(args.length);
		for (int i = 0; i < collectiondata.getDragons().size(); ++i) {
			console.println(collectiondata.getDragons().get(i).getCharacter().toString());
		}
	}
}
