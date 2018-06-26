package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ManageUsersController {
	
	@FXML  
	private Button butLogout;
	
	@FXML  
	private Button butHome;
	
	@FXML  
	private Button butAddUser;
	
	@FXML  
	private Button butRemoveUser;
	
	@FXML  
	private Button butGrantAdmin;
	
	@FXML  
	private Button butRemoveAdmin;
	
	@FXML  
	private Text txtUsername;
	
	@FXML  
	private Text txtType;
	
	@FXML  
	private Text txtID;
	
	@FXML  
	private ListView listUsers;
	
	public void selectUser(ActionEvent event) {
		
	}
	
	public void Logout(ActionEvent event) throws IOException { 
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Login.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butLogout.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Home(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Main.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butHome.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void AddUser(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/AddUser.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butHome.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}

	public void RemoveUser(ActionEvent event) {
		
	}
	
	public void GrantAdmin(ActionEvent event) {
		
	}

	public void RemoveAdmin(ActionEvent event) {
		
	}
}
