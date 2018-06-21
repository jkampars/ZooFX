package model;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
	private int id;
	private int MAX_CAPACITY;
	private int current_capacity;
	private List<Animal> animals = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Enclosure() {
		setId(0);
		setMAX_CAPACITY(0);
		setCurrent_capacity(0);
	}
	public Enclosure(int id, int mAX_CAPACITY, int current_capacity) {
		setId(id);
		setMAX_CAPACITY(mAX_CAPACITY);
		setCurrent_capacity(current_capacity);
	}
	public void addAnimal(Animal _animal) {
		animals.add(_animal);
	}
	public void removeAnimal(int whichAnimal) {
		animals.remove(whichAnimal);
	}
	
}






