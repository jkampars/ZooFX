package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Animal;
import model.Enclosure;
import model.User;

public class ManageUsersController extends Main implements Initializable{
	
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
	private ListView listUsers;
	
	public void selectUser(ActionEvent event) {
		User selected = (User) listUsers.getSelectionModel().getSelectedItem();
		txtUsername.setText(selected.getUsername());
		txtType.setText(selected.getUserType().name());
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<User> obslist = FXCollections.observableArrayList(users);
		listUsers.setItems(obslist);
	}
}
