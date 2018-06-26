package model;

import java.io.Serializable;

public class User implements Serializable{
	private String username;
	private String password;
	private UserType type;
	
	public User() {
		username="";
		password="";
		type = UserType.NOUSER;
	}
	
	public User(String name, String pass) {
		setUsername(name);
		setPassword(pass);
		type = UserType.NOUSER;
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
}
