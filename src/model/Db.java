package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Db {
	static Connection con = null;
	static Statement statement = null;
	
	public static void createConnection() throws ClassNotFoundException, SQLException {
		//Ielade SQL un izveido connection
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:zoodb.db");
		//createStudentsTable();
		//con.close();
	}
	
	public Db() throws ClassNotFoundException, SQLException {
		createConnection();
		statement = con.createStatement();
		//statement.executeUpdate("DROP TABLE IF EXISTS Students");
		//statement.executeUpdate("INSERT INTO users (username, password) VALUES ('admin','123');");
	}
	
	public ArrayList<String> getUsernames() throws SQLException {
		ResultSet results = statement.executeQuery("SELECT username FROM users;");
		ArrayList<String> result = new ArrayList();
		while (results.next()) {
			result.add(results.getString("username"));
		}
		return result;
	}
	/**
	public void createAnimalTable() throws SQLException {
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS Animals (" +
				"	 ID INTEGER PRIMARY KEY AUTOINCREMENT," +
				"    Name String," + 
				"    Specie String," + 
				"    Grade int"+
				");");
	}
	public void addStudent(Student student) throws SQLException {
		statement.executeUpdate("INSERT INTO Students (Name, Surname, Age, Grade)" + 
				"VALUES ('"+student.getFirstname()+"', '"+student.getLastname()+"', "+student.getAge()+", "+student.getGrade()+");");
	}
	
	public ArrayList<Student> selectAllStudentsSQL() throws SQLException{
		ArrayList<Student> result = new ArrayList();
		ResultSet results = statement.executeQuery("SELECT * FROM Students");
		while (results.next()) {
			//results.getString("Name");
			//results.getInt("Id");
			result.add(new Student(results.getInt("ID"), results.getString("Name"), results.getString("Surname"), results.getInt("Age")));
		}
		return result;
	}
	**/
	public void closeDB() throws SQLException {
		con.close();
	}

}
