package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.UserType;

public class MainController extends Main {
	
	@FXML
	private Button butLogout; 
	
	@FXML
	private Button butUsers; 
	
	@FXML
	private Button butAnimals; 
	
	@FXML
	private Button butEnclosures; 
	
	@FXML
	private Button butTickets; 
	
	
	public void Logout(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Login.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butLogout.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void ManageUsers(ActionEvent event) throws IOException {
		if (currentUser.getUserType()==UserType.ADMIN) {
			FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Login.fxml"));// create and load() view
			loader.load();
			Stage stage = (Stage) butUsers.getScene().getWindow();
			Scene scene = new Scene(loader.getRoot());
			stage.setScene(scene);
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Access denied");
            alert.setHeaderText("You are not allowed here");
            alert.setContentText("Only system admins have access");
            alert.show();
		}
	}
	
	public void Animals(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Animals.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butAnimals.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Enclosures(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Enclosures.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butEnclosures.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Tickets(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Login.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butTickets.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}


}
