package model;

public class Ticket {
	private int id;
	private String description;
	private String name;
	private int price;
	public static int counter = 1000;
	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	public void setName(String input) {
		name = input;
	}
	public void setPrice(int price) {
		if(priceChecker(price)) {
			this.price = price;
		}
		else {
			System.out.println("Invalid price");
		}
	}
	public boolean priceChecker(int price) {
		if(price >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public Ticket() {
		name="";
		counter++;
		id = counter + 1; 
		description = "";
		price = 0;
	}
	public Ticket(String name, String description, int price) {
		counter++;
		id = counter + 1;
		setDescription(description);
		setPrice(price);
		setName(name);
	}
}
