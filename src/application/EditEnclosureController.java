package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.AnimalType;
import model.Enclosure;

public class EditEnclosureController extends Main implements Initializable{
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
		///System.out.println(selectedEnclosure);
		boolean correctInput = true;
		if(Enclosure.checkName(txtName.getText())) {
			selectedEnclosure.setName(txtName.getText());
			selectedEnclosure.setType((AnimalType) selectType.getSelectionModel().getSelectedItem());
			if(txtCapacity.getText().matches("[0-9]*")) {
				int capacity = Integer.parseInt(txtCapacity.getText());
				selectedEnclosure.setMAX_CAPACITY(capacity);
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
		Stage stage = (Stage) butCancel.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Select(ActionEvent event) {
		
	}
	
	private Enclosure selectedEnclosure;

	public void showSelectedEnclosure(Enclosure input) {
		txtName.setText(input.getName());
		txtCapacity.setText(Integer.toString(input.getMAX_CAPACITY()));
		selectType.getSelectionModel().select(input.getType());
		for (int i=0;i<enclosures.size();i++) {
			if (enclosures.get(i).equals(input))
				selectedEnclosure = enclosures.get(i);
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		selectType.getItems().setAll(AnimalType.values());
	}
}
