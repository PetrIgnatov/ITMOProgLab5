package ru.se.ifmo.prog.lab5.commands;

import ru.se.ifmo.prog.lab5.cores.*;

public class Exit extends Command {
	public Exit(CommandManager commandmanager, Console console) {
		super("exit", "завершить программу (без сохранения в файл)", 1, commandmanager, console);
	}
	@Override
	public void execute(String[] args) {
		super.check(args.length);
		console.stop();	
	}
}
