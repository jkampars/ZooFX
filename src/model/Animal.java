package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Animal { 
	private int ID;
	private String name;
	private AnimalType type;
	private ArrayList<Diet> diet = new ArrayList();
	private static int counter = 1000;
	
	private Date dateAdded;
	
	public int getID() {
		return ID;
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
		counter++;
		ID = counter;
		type=AnimalType.NONE;
		dateAdded = new Date();
	}
	public Animal(String name, AnimalType type) {
		setName(name);
		setType(type);
		counter++;
		ID = counter;
		dateAdded = new Date();
	}
	public boolean checkName(String name) {
		if(name.matches("[a-zA-Z0-9]*")) {
			return true;
		}
		else { 
			return false;
		}
	}
	public ArrayList<Diet> getDiet() {
		return diet;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public String toString() {
		return name+" "+ID;
	}
	public void setDiet(ArrayList<Diet> diet) {
		this.diet = diet;
	}
	
}
