package ru.se.ifmo.prog.lab5.classes;

public class DragonCave implements Comparable<DragonCave> {
	private Double depth; //Поле не может быть null
	private Float numberOfTreasures; //Поле может быть null, Значение поля должно быть больше 0
	
	public double getDepth() {
		return depth.doubleValue();
	}
	
	public float getNumberOfTreasures() {
		return numberOfTreasures.floatValue();
	}
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}
		DragonCave cave = (DragonCave)other;
		return (this.depth.doubleValue() == cave.getDepth() && this.numberOfTreasures.floatValue() == cave.getNumberOfTreasures());
	}
	@Override
	public int hashCode() {
		return (int)(depth.doubleValue()*1000001+(double)numberOfTreasures.floatValue());
	}
	@Override
	public int compareTo(DragonCave other) {
		if (depth.doubleValue() < other.getDepth()) {
			return -1;
		}
		if (depth.doubleValue() > other.getDepth()) {
			return 1;
		}
		if (numberOfTreasures.doubleValue() < other.getNumberOfTreasures()) {
			return -1;
		}
		if (numberOfTreasures.doubleValue() > other.getNumberOfTreasures()) {
			return 1;
		}
		return 0;
	}
}
