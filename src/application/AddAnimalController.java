package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddAnimalController {
	
	@FXML  
	private Button butLogout;

	@FXML  
	private Button butAdd;
	
	@FXML  
	private Button butRemove;

	@FXML  
	private Button butAccept;

	@FXML  
	private Button butCancel;
	
	@FXML  
	private ComboBox SelectEnclosure;
	
	@FXML  
	private TextField txtName;

	@FXML  
	private TextField txtSpecie;

	@FXML  
	private TextField txtFood;

	@FXML  
	private TextField txtHour;
	
	@FXML  
	private TextField txtMinutes;
	
	@FXML  
	private ListView listFood;
	
	@FXML  
	private ListView listTime;
	
	public void Enclosure(ActionEvent event) {
		
	}
	
	public void Logout(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Login.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butLogout.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Add(ActionEvent event) {
			
	}
	
	public void Remove(ActionEvent event) {
		
	}
	
	public void Accept(ActionEvent event) {
		
	}
	
	public void Cancel(ActionEvent event) {
		
	}
}
