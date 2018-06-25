package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Diet {
	ArrayList<String> servingTypes;
	ArrayList<Time> servingTimes;
	
	public ArrayList<String> getServingTypes() {
		return servingTypes;
	}
	public ArrayList<Time> getServingTimes() {
		return servingTimes;
	}
	
	public void addFood(String food, Time time) {
		servingTypes.add(food);
		servingTimes.add(time);
	}
}

