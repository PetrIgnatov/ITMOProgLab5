package ru.se.ifmo.prog.lab5;
import ru.se.ifmo.prog.lab5.classes.*;
import ru.se.ifmo.prog.lab5.commands.*;
import ru.se.ifmo.prog.lab5.cores.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Error! Got " + Integer.valueOf(args.length) + " arguments when 1 required (file name)");
		}
		CollectionData collection = new CollectionData(args[0]);
		CommandManager commandmanager = new CommandManager();
		Console console = new Console(commandmanager, collection);
		commandmanager.createCommand("help", new Help(commandmanager, console));
		commandmanager.createCommand("info", new Info(commandmanager, console));
		commandmanager.createCommand("show", new Show(commandmanager, console));
		commandmanager.createCommand("clear", new Clear(commandmanager, console, collection));
		commandmanager.createCommand("exit", new Exit(commandmanager, console));
		commandmanager.createCommand("sort", new Sort(commandmanager, console, collection));
		commandmanager.createCommand("history", new History(commandmanager, console));
		console.start();
	}
}
