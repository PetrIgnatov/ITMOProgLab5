package ru.se.ifmo.prog.lab5;
import ru.se.ifmo.prog.lab5.classes.*;

public class Main {
	public static void main(String[] args) {
		Dragon dr = new Dragon(1, "   ", new Coordinates(), new java.util.Date(), 1, Color.GREEN, DragonType.WATER, DragonCharacter.EVIL, new DragonCave());
	}
}
