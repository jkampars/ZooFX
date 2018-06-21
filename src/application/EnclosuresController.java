package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class EnclosuresController {
	
	@FXML  
	private Button butLogout;
	
	@FXML  
	private Button butHome;
	
	@FXML  
	private Button butAddEnclosure;
	
	@FXML  
	private Button butRemoveEnclosure;
	
	@FXML  
	private Button butEditEnclosure;
	
	@FXML  
	private Button butMoveAnimal;
	
	@FXML  
	private Button butRemoveAnimal;
	
	@FXML  
	private ListView listEnclosures;
	
	@FXML  
	private ListView listAnimals;
	
	public void ShowAnimals(ActionEvent event) {
			
	}
	
	public void SelectAnimal(ActionEvent event) {
		
	}
	
	public void Logout(ActionEvent event) {
		
	}
	
	public void Home(ActionEvent event) {
			
	}
	
	public void AddEnclosure(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/AddEnclosure.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butAddEnclosure.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void RemoveEnclosure(ActionEvent event) {
		
	}
	
	public void EditEnclosure(ActionEvent event) {
		
	}
	
	public void MoveAnimal(ActionEvent event) {
		
	}
	
	public void RemoveAnimal(ActionEvent event) {
		
	}
}
