package ru.se.ifmo.prog.lab5.cores;

import java.util.LinkedList;
import ru.se.ifmo.prog.lab5.classes.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Collections;

public class CollectionData {
	private LinkedList<Dragon> dragons;
	private String filename;
	private java.util.Date initDate;	
	public CollectionData(String filename) {
		initDate = new java.util.Date();
		this.filename = filename;
		dragons = new LinkedList<Dragon>();
		try {
			FileInputStream inputStream = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(inputStream);
			int temp;
			String inputDragon = "";
			while ((temp = reader.read()) != -1) {
				if (temp != 10) {
					inputDragon += (char)temp;
				}
				else {
					try {
						String[] splitted = new String[11];
						for (int i = 0; i < 11; ++i) {
							splitted[i] = "";
						}
						int pos = 0;
						for (int i = 0; i < inputDragon.length(); ++i) {
							if (inputDragon.charAt(i) == ';') {
								++pos;
								if ((i == inputDragon.length()-1 && pos != 11) || (i < inputDragon.length()-1 && pos >= 11)) {
									throw new IOException("Error! The given file's data doesn't match the required type");
								}
							}
							else
							{
								if ((i == inputDragon.length()-1 && pos != 10) || pos >= 11) {
									throw new IOException("Error! The given file's data doesn't match the required type");
								}
								splitted[pos] += inputDragon.charAt(i);
							}
						}
						Color col = null;
						switch(splitted[6]) {
							case "GREEN":
								col = Color.GREEN;
								break;
							case "YELLOW":
								col = Color.YELLOW;
								break;
							case "ORANGE":
								col = Color.ORANGE;
								break;
							case "WHITE":
								col = Color.WHITE;
								break;	
							case "":
								col = null;
								break;
							default:
								throw new IOException("Error! Unknown color \"" + splitted[6] + "\"");
						}
						DragonType type = null; 
						switch(splitted[7]) {
							case "WATER":
								type = DragonType.WATER;
								break;
							case "UNDERGROUND":
								type = DragonType.UNDERGROUND;	
								break;
							case "AIR":
								type = DragonType.AIR;
								break;
							case "":
								type = null;
								break;
							default:
								throw new IOException("Error! Unknown type \"" + splitted[7] + "\"");
						}
						DragonCharacter character = null;
						switch(splitted[8]) {
							case "EVIL":
								character = DragonCharacter.EVIL;
								break;
							case "GOOD":
								character = DragonCharacter.GOOD;	
								break;
							case "CHAOTIC":
								character = DragonCharacter.CHAOTIC;
								break;
							case "FICKLE":
								character = DragonCharacter.FICKLE;	
								break;
							case "CHAOTIC_EVIL":
								character = DragonCharacter.CHAOTIC_EVIL;
								break;
							case "":
								character = null;
								break;
							default:
								throw new IOException("Error! Unknown character \"" + splitted[8] + "\"");
						}
						String format = "EEE MMM dd HH:mm:ss z yyyy";
						SimpleDateFormat formater = new SimpleDateFormat(format, Locale.ENGLISH);
						java.util.Date date = null;
						date = formater.parse(splitted[4]);
						dragons.add(new Dragon(
									Integer.parseInt(splitted[0]),
									splitted[1] == "" ? null : splitted[1],
									splitted[2] == "" ? null : Integer.parseInt(splitted[2]),
									splitted[3] == "" ? null : Float.parseFloat(splitted[3]),
									date,
									Integer.parseInt(splitted[5]),
									col,type,character,
									splitted[9] == "" ? null : Double.parseDouble(splitted[9]),
									splitted[10] == "" ? null : Float.parseFloat(splitted[10])));
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
					finally {
						inputDragon = "";
					}
				}
			}	
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public LinkedList<Dragon> getDragons() {
		return dragons;
	}

	public void clear() {
		dragons.clear();
	}
	public void sort() {
		Collections.sort(dragons);
	}	
	@Override
	public String toString() {
		return "LinkedList<Dragon>;" + initDate.toString() + ";" + Integer.toString(dragons.size()) + " elements;";
	}
}
