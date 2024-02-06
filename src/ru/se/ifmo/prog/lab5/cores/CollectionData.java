package ru.se.ifmo.prog.lab5.cores;

import java.util.LinkedList;
import ru.se.ifmo.prog.lab5.classes.*;
import java.io.*;
public class CollectionData {
	LinkedList<Dragon> dragons;
	String filename;	

	public CollectionData(String filename) {
		this.filename = filename;
		dragons = new LinkedList<Dragon>();
		try {
			FileInputStream inputStream = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(inputStream);
			int temp;
			while ((temp = reader.read()) != -1) {
				System.out.println("Got char " + (char)temp);
			}	
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}	
}
