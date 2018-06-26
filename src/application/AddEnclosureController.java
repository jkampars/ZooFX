package application;

import java.io.IOException;

import javax.swing.DefaultComboBoxModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.AnimalType;
import model.Enclosure;

public class AddEnclosureController extends Main{
	
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
	
	public void initialize() {
		selectType.getItems().addAll(AnimalType.values());
	}
	public void Logout(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Login.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butLogout.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Accept(ActionEvent event) throws IOException {
		boolean correctInput = true;
		
		Enclosure buris = new Enclosure();
		if(Enclosure.checkName(txtName.getText())) {
			buris.setName(txtName.getText());
			System.out.println(txtName.getText());
			buris.setType((AnimalType) selectType.getSelectionModel().getSelectedItem());
			System.out.println((AnimalType) selectType.getSelectionModel().getSelectedItem());
			if(txtCapacity.getText().matches("[0-9]*")) {
				int capacity = Integer.parseInt(txtCapacity.getText());
				buris.setMAX_CAPACITY(capacity);
				System.out.println(capacity);
				enclosures.add(buris);
				System.out.println("Enclosure has been made");
				for (Enclosure i : enclosures) {
					System.out.println(i.getName());
				}
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Enclosure size input fail");
	            alert.setHeaderText("Enclosure size consists only of numbers");
	            alert.show();
	            correctInput = false;
			}
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Enclosure name input fail");
            alert.setHeaderText("Enclosure name consists only of letters and numbers");
            alert.show();
            correctInput = false;
		}
		
		if(correctInput) {
			FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Enclosures.fxml"));// create and load() view
			loader.load();
			Stage stage = (Stage) butAccept.getScene().getWindow();
			Scene scene = new Scene(loader.getRoot());
			stage.setScene(scene);
		}
		
	}
	
	public void Cancel(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Enclosures.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butAccept.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Select(MouseEvent event) {
		
	}
}
