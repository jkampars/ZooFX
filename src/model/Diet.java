package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Diet {
	private int hours;
	private int min;
	private String food;
	
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	
	public String toString(){
		return hours+":"+min+" - "+food;
	}
}

