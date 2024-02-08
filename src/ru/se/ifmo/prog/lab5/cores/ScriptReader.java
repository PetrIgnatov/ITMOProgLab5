package ru.se.ifmo.prog.lab5.cores;

import java.io.*;

public class ScriptReader {
	private String filename;
	FileInputStream inputStream;
	InputStreamReader reader;

	public ScriptReader(String filename) {
		try {
			inputStream = new FileInputStream(filename);
			reader = new InputStreamReader(inputStream);
		}
		catch (FileNotFoundException e) {
			System.out.println("Error! File \"" + filename + "\" not found");
		}
	}

	public String readFile() {
		int temp;
		String file = "";
		try {
			while ((temp = reader.read()) != -1) {
				file += (char)temp;
			}
		}
		catch (IOException e) {
			System.out.println("Error! Something is wrong with file data");
		}
		return file;
	}
}
