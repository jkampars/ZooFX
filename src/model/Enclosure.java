package model;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
	private int id;
	private int MAX_CAPACITY;
	private int current_capacity;
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
		return current_capacity;
	}
	public void setCurrent_capacity(int current_capacity) {
		this.current_capacity = current_capacity;
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
	public boolean checkName(String name) {
		if (name.matches("[a-zA-Z0-9]*")) 
			return true;
		else 
			return false;
	}
	public void addAnimal(Animal animal) {
		animals.add(animal);
		current_capacity++;
	}
	public void removeAnimal(int index) {
		animals.remove(index);
		current_capacity--;
	}
	public Enclosure() {
		counter++;
		id = counter + 1;
		name = "";
		MAX_CAPACITY = 0;
		current_capacity = 0;
		type = AnimalType.NONE;
	}
	public Enclosure(int mAX_CAPACITY, int current_capacity, String name, AnimalType type) {
		counter++;
		id = counter + 1;
		setMAX_CAPACITY(mAX_CAPACITY);
		setCurrent_capacity(current_capacity);
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
		if (current_capacity==0)
			return true;
		else
			return false;
	}
	public void removeAnimal(Animal animal) {
		if (animals.contains(animal)) {
			animals.remove(animal);
			current_capacity--;
		}
	}
	public boolean isFull() {
		if (current_capacity==MAX_CAPACITY)
			return true;
		else
			return false;
	}
}






