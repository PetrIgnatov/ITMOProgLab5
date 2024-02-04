package ru.se.ifmo.prog.lab5.classes;

public class Coordinates implements Comparable<Coordinates> {
	private Integer x; //Значение поля должно быть больше -32, Поле не может быть null
	private Float y; //Поле не может быть null
			 
	public int getX() {
		return this.x.intValue();
	}
	
	public float getY() {
		return this.y.floatValue();
	}
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}
		Coordinates coordinates = (Coordinates)other;
		return (this.x.intValue() == coordinates.getX() && this.y.floatValue() == coordinates.getY());
	}
	@Override
	public int hashCode()
	{
		return (int)(y.floatValue()*1000001)+x.intValue();
	}
	@Override
	public int compareTo(Coordinates other) {
		if (this.x.intValue() < other.getX()) {
			return -1;
		}
		if (this.x.intValue() > other.getX()) {
			return 1;
		}
		if (this.y.floatValue() < other.getY()) {
			return -1;
		}
		if (this.y.floatValue() > other.getY()) {
			return 1;
		}
		return 0;
	}
}
