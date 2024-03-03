package ru.se.ifmo.prog.lab5.commands;

import ru.se.ifmo.prog.lab5.cores.*;

public class ExecuteScript extends Command {
	public ExecuteScript(CommandManager commandmanager, Console console) {
		super("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.", 2, commandmanager, console);
	}
	@Override
	public void execute(String[] args) {
		super.check(args.length);
		console.readScript(args[1]);
	}
}

