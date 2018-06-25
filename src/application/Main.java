package application;
	
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.User;
import model.Animal;
import model.AnimalType;
import model.Db;
import model.Enclosure;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	public static ArrayList<User> users = new ArrayList();
	public static User currentUser = new User();
	public static ArrayList<Enclosure> enclosures = new ArrayList();
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
			Scene scene = new Scene(root,700,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Db database = new Db();
		users.add(new User("1","1"));
		users.add(new User("user","pass"));
		users.add(new User("admin","123"));
		users.add(new User("",""));
		users.get(3).setAdmin();
		users.get(2).setAdmin();
		users.get(1).setUser();
		Enclosure buris1 = new Enclosure(10,0,"Putni",AnimalType.BIRD);
		Enclosure buris2 = new Enclosure(5,0,"Zivis",AnimalType.FISH);
		Enclosure buris3 = new Enclosure(3,0,"Lapsas",AnimalType.MAMMAL);
		buris1.addAnimal(new Animal("Dzenis",AnimalType.BIRD));
		buris1.addAnimal(new Animal("Zilite",AnimalType.BIRD));
		buris2.addAnimal(new Animal("Karpa",AnimalType.FISH));
		buris2.addAnimal(new Animal("Lasis",AnimalType.FISH));
		buris2.addAnimal(new Animal("Lidaka",AnimalType.FISH));
		buris3.addAnimal(new Animal("Riza",AnimalType.MAMMAL));
		buris3.addAnimal(new Animal("NeRiza",AnimalType.MAMMAL));
		enclosures.add(buris1);
		enclosures.add(buris2);
		enclosures.add(buris3);
		System.out.println(database.getUsernames());
		launch(args);
	}

}
