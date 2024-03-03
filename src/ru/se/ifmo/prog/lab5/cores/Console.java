package ru.se.ifmo.prog.lab5.cores;

import java.util.*;
import java.io.*;
import java.awt.event.*;
import ru.se.ifmo.prog.lab5.commands.*;
import ru.se.ifmo.prog.lab5.classes.*;

public class Console {
	private Scanner scanner;
	private boolean active;
	private CommandManager commandmanager;
	private CollectionData collectiondata;
	private LinkedList<Command> history;
	private LinkedList<String> commandsStack;
	private int stacksize;

	public Console(CommandManager commandmanager, CollectionData collectiondata)
	{
		this.scanner = new Scanner(System.in);
		this.active = true;
		this.history = new LinkedList<Command>();
		this.commandmanager = commandmanager;
		this.collectiondata = collectiondata;
		this.commandsStack = new LinkedList<String>();
		this.stacksize = 0;
	}
	
	public void start() {
		while (this.active) {
			readCommand();
		}
	}

	public void print(String line)
	{
		if (line.equals(null))
		{
			return;
		}
		System.out.print(line);
	}

	public void println(String line)
	{
		if (line.equals(null))
		{
			System.out.println();
			return;
		}
		System.out.println(line);
	}

	public void readCommand() {
		String[] com; 
		if (commandsStack.size() == 0) {
			stacksize = 0;
			com = scanner.nextLine().split(" ");
		}
		else {
			this.println(commandsStack.peek());
			com = commandsStack.removeFirst().split(" ");
		}
		if (com.length > 0) {
			try {
				Command command = commandmanager.getCommand(com[0]);
				if (command != null) {
					history.push(command);
					while (history.size() > 5) {
						history.pollLast();
					}
				}
				command.execute(com);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String readln() {
		if (commandsStack.size() == 0) {
			stacksize = 0;
			return scanner.nextLine();
		}
		else {
			this.println(commandsStack.peek());
			return commandsStack.removeFirst();
		}
	}
	
	public void stop() {
		active = false;
	}

	public void printCollection() {
		for (Dragon dragon : collectiondata.getDragons()) {
			println(dragon.toString());
		}
	}
	
	public void printInfo() {
		println(collectiondata.toString());
	}

	public void printHistory() {
		for (int i = history.size()-1; i >= 0; i--) {
			println(history.get(i).getName());
		}	
	}

	public void readScript(String filename) {
		if (stacksize < 10000)
		{
			try {	
				ScriptReader scriptreader = new ScriptReader(filename);
				String inpfile = scriptreader.readFile();
				if (inpfile != null)
				{
					String[] commands = inpfile.split("\n");
					for (int i = commands.length-1; i >= 0; i--) {
						++stacksize;
						commandsStack.offerFirst(commands[i]);
					}
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("Error! Too many commands!");
		}
	}
}

