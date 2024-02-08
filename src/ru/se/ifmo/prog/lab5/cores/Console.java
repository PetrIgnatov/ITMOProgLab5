package ru.se.ifmo.prog.lab5.cores;

import java.util.*;
import java.io.*;
import ru.se.ifmo.prog.lab5.commands.*;
import ru.se.ifmo.prog.lab5.classes.*;

public class Console {
	private Scanner scanner;
	private boolean active;
	private CommandManager commandmanager;
	private CollectionData collectiondata;
	private LinkedList<Command> history;
	private int depth;

	public Console(CommandManager commandmanager, CollectionData collectiondata)
	{
		scanner = new Scanner(System.in);
		active = true;
		this.history = new LinkedList<Command>();
		this.commandmanager = commandmanager;
		this.collectiondata = collectiondata;
		depth = 0;
	}
	
	public void start() {
		while (active) {
			readCommand();
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
	
	public void getCommand(String line) {
		if (active) {			
			this.print("[GLaDOS]>");
			String[] com = line.split(" ");
			if (com.length > 0) {
				try {
					Command command = commandmanager.getCommand(com[0]);
					if (command != null) {
						history.push(command);
						while (history.size() > 5) {
							history.pollLast();
						}
					}
					this.println(line);
					command.execute(com);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public void readCommand() {
		this.print("[GLaDOS]>");
		String[] com = scanner.nextLine().split(" ");
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
		return scanner.nextLine();
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
		if (depth < 5)
		{
			try {	
				ScriptReader scriptreader = new ScriptReader(filename);
				String[] commands = scriptreader.readFile().split("\n");
				++depth;
				for (int i = 0; i < commands.length; ++i) {
					this.getCommand(commands[i]);
				}
				--depth;
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("Error! Look like your scripts is awakening in recursion. Try recoding it");
		}
	}
}
