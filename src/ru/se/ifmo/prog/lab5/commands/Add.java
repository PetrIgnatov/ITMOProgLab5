package ru.se.ifmo.prog.lab5.commands;

import ru.se.ifmo.prog.lab5.cores.*;

public class Add extends Command {
	public Add(CommandManager commandmanager, Console console, CollectionData collectiondata) {
		super("add {element}", "добавить новый элемент в коллекцию", 1, commandmanager, console, collectiondata, new String[]{"Имя дракона: ", "Координата X: ", "Координата Y: ", "Возраст: ", "Цвет (доступные варианты - GREEN, YELLOW, ORANGE, WHITE): ", "Тип дракона (доступные варианты - WATER, UNDERGROUND, AIR): ", "Характер дракона (доступные варианты - EVIL, GOOD, CHAOTIC, CHAOTIC_EVIL, FICKLE): ", "Глубина пещеры: ", "Количество сокровищ в пещере: "});
	}
	@Override
	public void execute(String[] args) {
		super.check(args.length);
		String[] parameter = new String[parametersAdvices.length];
		for (int i = 0; i < parameter.length; ++i) {
			console.print(parametersAdvices[i]);
			parameter[i] = console.readln();
			if (parameter[i].split(" ").length > 1 && i != 0) {
				throw new IllegalArgumentException("Error! Unable to use this input!");
			}
		}	
		collectiondata.add(parameter);
	}
}

