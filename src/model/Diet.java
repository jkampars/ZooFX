package model;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Diet implements Serializable{
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
		if (hours<10 && min<10)
			return "0"+hours+":0"+min+" - "+food;
		else if (hours<10)
			return "0"+hours+":"+min+" - "+food;
		else if (min<10)
			return hours+":0"+min+" - "+food;
		else
			return hours+":"+min+" - "+food;
	}
}

