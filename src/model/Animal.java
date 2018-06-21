package model;

import java.util.ArrayList;

public class Animal {
	private int ID;
	private String name;
	private AnimalType type;
	private ArrayList<Diet> diet = new ArrayList();
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(checkName(name)) {
			this.name = name;
		}
		else {
			System.out.println("Name input fail");
		}
	}
	public AnimalType getType() {
		return type;
	}
	public void setType(AnimalType type) {
		this.type = type;
	}
	public Animal() {
		name="";
		ID=0;
		type=AnimalType.NONE;
		
	}
	public Animal(int iD, String name, AnimalType type) {
		setID(iD);
		setName(name);
		setType(type);
	}
	public boolean checkName(String name) {
		if(name.matches("[a-zA-Z0-9]*")) {
			return true;
		}
		else {
			return false;
		}
	}
}
