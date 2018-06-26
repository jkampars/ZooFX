package application;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Animal;
import model.AnimalType;
import model.Diet;

public class AddAnimalController extends Main{
	
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
	private ComboBox listSpecie;

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
	
	private ArrayList<Diet> diet = new ArrayList<Diet>();
	
	public void Enclosure(ActionEvent event) {
		
	}
	public void selectSpecie(ActionEvent event) {
		
	}
	public void Logout(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Login.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butLogout.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Add(ActionEvent event) {
		if(txtFood.getText() != "" && (Integer.valueOf(txtHour.getText()) >= 0 && Integer.valueOf(txtHour.getText()) <= 23) && (Integer.valueOf(txtMinutes.getText()) >= 0 && Integer.valueOf(txtMinutes.getText()) <= 59)) {
			Time time = new Time(0);
			time.setHours(Integer.valueOf(txtHour.getText()));
			time.setMinutes(Integer.valueOf(txtMinutes.getText()));
			Diet serving = new Diet();
			serving.addFood(txtFood.getText(), time);
			diet.add(serving);
		}
	}
	
	public void Remove(ActionEvent event) {
		
	}
	
	public void Accept(ActionEvent event) throws IOException {
		Animal animal = new Animal();
		animal.setName(txtName.getText());
		animal.setType((AnimalType) listSpecie.getSelectionModel().getSelectedItem());
		animal.setDiet(diet);
		if(enclosures.contains(SelectEnclosure.getSelectionModel().getSelectedItem())) {
			enclosures.get(enclosures.indexOf(SelectEnclosure.getSelectionModel().getSelectedItem())).addAnimal(animal);;
		}
		
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Animals.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butAccept.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Cancel(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Animals.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butCancel.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void initialize() {
		SelectEnclosure.getItems().addAll(enclosures);
		listSpecie.getItems().setAll(AnimalType.values());
		
		listFood.getItems().addAll(diet);
		listTime.getItems().addAll(diet);
	}
}
