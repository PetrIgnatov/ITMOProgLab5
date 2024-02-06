package ru.se.ifmo.prog.lab5.commands;

public interface Executable {
	public String getName();
	public String getDescription();
	public void execute(String[] args);
}
