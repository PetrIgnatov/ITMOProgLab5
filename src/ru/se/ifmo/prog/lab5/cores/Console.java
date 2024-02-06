package ru.se.ifmo.prog.lab5.cores;

import java.util.*;

public class Console {
	private Scanner scanner;
	private CommandManager commandmanager;
	private boolean active;
	public Console()
	{
		scanner = new Scanner(System.in);
		active = true;
	}
	
	public void start(CommandManager commandmanager) {
		while (active) {
			readCommand(commandmanager);
		}
	}

	public void print(String line)
	{
		if (line == null)
		{
			return;
		}
		System.out.print(line);
	}

	public void println(String line)
	{
		if (line == null)
		{
			System.out.println();
			return;
		}
		System.out.println(line);
	}

	public void readCommand(CommandManager commandmanager)
	{
		this.print("[GLaDOS]>");
		String[] com = scanner.nextLine().split(" ");
		if (com.length > 0)
		{
			commandmanager.getCommand(com[0]).execute(com);
		}
	}
	
	public void stop() {
		active = false;
	}
}
