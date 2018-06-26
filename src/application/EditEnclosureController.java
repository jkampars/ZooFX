package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditEnclosureController {

	@FXML  
	private Button butLogout;
	
	@FXML  
	private Button butAccept;
	
	@FXML  
	private Button butCancel;
	
	@FXML  
	private TextField txtName;
	
	@FXML  
	private TextField txtCapacity;
	
	@FXML  
	private ComboBox selectType;
	
	public void Logout(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Login.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butLogout.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Accept(ActionEvent event) throws IOException {
		boolean correctInput = true;
		
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Enclosures.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butAccept.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Cancel(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Enclosures.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butCancel.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Select(ActionEvent event) {
		
	}
}
