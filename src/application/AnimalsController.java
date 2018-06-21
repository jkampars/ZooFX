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

public class AnimalsController {
	
	@FXML  
	private Button butLogout;
	
	@FXML  
	private Button butHome;
	
	@FXML  
	private Button butAddAnimal;
	
	@FXML  
	private Button butRemoveAnimal;
	
	@FXML  
	private Button butEditAnimal;
	
	@FXML  
	private ListView listAnimals;
	
	@FXML  
	private ListView food;
	
	@FXML  
	private ListView time;
	
	@FXML  
	private Text txtID;
	
	@FXML  
	private Text txtName;
	
	@FXML  
	private Text txtSpecie;
	
	@FXML
	private Text txtEnclosure;
	
	@FXML  
	private Text txtDate;
	
	
	public void Logout(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Login.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butLogout.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
<<<<<<< HEAD
	public void Home(ActionEvent event) {
			
=======
	public void Home(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Main.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butHome.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
>>>>>>> branch 'master' of https://github.com/jkampars/ZooFX.git
	}
	
	public void AddAnimal(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/AddAnimal.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butAddAnimal.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void EditAnimal(ActionEvent event) {
		
	}
	
	public void Remove(ActionEvent event) {
		
	}
	
	public void Info(ActionEvent event) {
		
	}
}
