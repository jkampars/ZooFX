package model;

public class User {
	private String username;
	private String password;
	private UserType type;
	private int id;
	private static int counter = 0;
	
	public User() {
		username="";
		password="";
		counter++;
		id = 1000 + counter;
		type = UserType.NOUSER;
	}
	
	public User(String name, String pass) {
		setUsername(name);
		setPassword(pass);
		type = UserType.NOUSER;
		counter++;
		id = 1000 + counter;
	}
	
	public boolean checkUsername(String name) {
		if (name.matches("[a-zA-Z0-9]*")) 
			return true;
		else 
			return false;
	}
	
	public boolean checkPassword(String pass) {
		if (pass.matches("[a-zA-Z0-9]*")) {
			return true;
		}
		else 
			return false;
	}
	
	public void setUsername(String name) {
		if (checkUsername(name))
			username = name;
		else System.out.println("Username input fail");
	}
	
	public void setPassword(String pass) {
		if (checkPassword(pass))
			password = pass;
		else System.out.println("Password input fail");
	}
	
	public void setUser() {
		type = UserType.USER;
	}
	
	public void setAdmin() {
		type = UserType.ADMIN;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public UserType getUserType() {
		return type;
	}
	
	public int getId() {
		return id;
	}
}
