package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Enclosure implements Serializable{
	private int id;
	private int MAX_CAPACITY;
	private ArrayList<Animal> animals = new ArrayList<>();
	public static int counter = 1000;
	private String name;
	private AnimalType type;
	
	public int getMAX_CAPACITY() {
		return MAX_CAPACITY;
	}
	
	public void setMAX_CAPACITY(int mAX_CAPACITY) {
		MAX_CAPACITY = mAX_CAPACITY;
	}
	
	public int getCurrent_capacity() {
		return animals.size();
	}
	
	public ArrayList<Animal> getAnimals() {
		return animals;
	}
	
	public void setAnimals(Animal animal) {
		animals.add(animal);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String _name) {
		if(checkName(_name)) {
			name = _name;
		}
		
		else {
			System.out.println("Invalid name");
		}
	}
	
	public AnimalType getType() {
		return type;
	}
	
	public void setType(AnimalType type) {
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public static boolean checkName(String name) {
		if (name.matches("[a-zA-Z0-9]*")) 
			return true;
		
		else 
			return false;
	}
	
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	
	public void removeAnimal(int index) {
		animals.remove(index);
	}
	
	public Enclosure() {
		counter++;
		id = counter + 1;
		name = "";
		MAX_CAPACITY = 0;
		type = AnimalType.NONE;
	}
	
	public Enclosure(int mAX_CAPACITY, String name, AnimalType type) {
		counter++;
		id = counter + 1;
		setMAX_CAPACITY(mAX_CAPACITY);
		setName(name);
		setType(type);
	}
	
	public String toString() {
		return name;
	}
	
	public boolean animalsIsEmpty() {
		if(animals.isEmpty()) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if (animals.size()==0)
			return true;
		
		else
			return false;
	}
	
	public void removeAnimal(Animal animal) {
		if (animals.contains(animal)) {
			animals.remove(animal);
		}
	}
	
	public boolean isFull() {
		if (animals.size()==MAX_CAPACITY)
			return true;
		
		else
			return false;
	}
}






