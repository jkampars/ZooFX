package model;

import java.util.ArrayList;

public class Purchase {
	private ArrayList<String> tickets = new ArrayList();
	private int sum;
	
	public Purchase() {
		sum = 0;
	}
	
	public Purchase(ArrayList<Ticket> input) {
		for (int i=0;i<input.size();i++) {
			sum = sum + input.get(i).getPrice();
			for (Ticket ticket : input) {
				
			}
		}
	}
}
