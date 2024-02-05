package ru.se.ifmo.prog.lab5;
import ru.se.ifmo.prog.lab5.classes.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Random rand = new Random();
		LinkedList<Dragon> dr = new LinkedList<>();
	       	for (int i = 0; i < 10; ++i) {
			Dragon newdr = new Dragon(rand.nextInt(1000), "Another dragon", new Coordinates(1,2.0f), new java.util.Date(), 1, Color.GREEN, DragonType.WATER, DragonCharacter.EVIL, new DragonCave(Double.valueOf(100),null)); 
			dr.add(newdr);
			System.out.println(newdr.getId());
		}
		Collections.sort(dr);
		for (int i = 0; i < 10; ++i) {
			System.out.println(dr.get(i).toString());
		}
	}
}
