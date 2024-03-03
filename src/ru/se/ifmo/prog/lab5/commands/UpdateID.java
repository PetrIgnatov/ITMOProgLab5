package ru.se.ifmo.prog.lab5.commands;

import ru.se.ifmo.prog.lab5.cores.*;

public class UpdateID extends Command {
	public UpdateID(CommandManager commandmanager, Console console, CollectionData collection) {
		super("update id {element}", "обновить значение элемента коллекции, id которого равен заданному", 2, commandmanager, console, collection, new String[]{"Имя дракона: ", "Координата X: ", "Координата Y: ", "Возраст: ", "Цвет (доступные варианты - GREEN, YELLOW, ORANGE, WHITE): ", "Тип дракона (доступные варианты - WATER, UNDERGROUND, AIR): ", "Характер дракона (доступные варианты - EVIL, GOOD, CHAOTIC, CHAOTIC_EVIL, FICKLE): ", "Глубина пещеры: ", "Количество сокровищ в пещере: "}); 
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
		int index = collectiondata.findById(Integer.parseInt(args[1]));
		if (index == -1) {
			throw new IllegalArgumentException("Error! Dragon with ID " + args[1] + " not found");
		}
                String[] parameter = new String[parametersAdvices.length];
                for (int i = 0; i < parameter.length; ++i) {
                        console.print(parametersAdvices[i]);
                        parameter[i] = console.readln();
                        if (parameter[i].split(" ").length > 1 && i != 0) {
                                throw new IllegalArgumentException("Error! Unable to use this input!");
                        }
                }
                collectiondata.update(parameter, index, Integer.parseInt(args[1]));
        }
}

