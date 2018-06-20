package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	static Connection con = null;
	static Statement statement = null;
	
	public static void createConnection() throws ClassNotFoundException, SQLException {
		//Ielade SQL un izveido connection
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:IIHF16.db");
		//createStudentsTable();
		//con.close();
	}
	
	public Db() throws ClassNotFoundException, SQLException {
		createConnection();
		statement = con.createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS Students");

	}
	
	public void createAnimalTable() throws SQLException {
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS Animals (" +
				"	 ID INTEGER PRIMARY KEY AUTOINCREMENT," +
				"    Name String," + 
				"    Specie String," + 
				"    Grade int"+
				");");
	}
	/**
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
