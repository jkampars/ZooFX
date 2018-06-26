package application;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.scene.control.SelectedCellsMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList; 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	private ComboBox comboHour;
	
	@FXML  
	private ComboBox comboMinutes;
	
	@FXML  
	private ListView listFood;
	
	
	public void Enclosure(ActionEvent event) {
		//SelectEnclosure.getItems().addAll(enclosures);
		//listSpecie.getItems().setAll(AnimalType.values());
		model.Enclosure selectedType =  (model.Enclosure)SelectEnclosure.getSelectionModel().getSelectedItem();
		listSpecie.getItems().clear();
		listSpecie.getItems().add(selectedType.getType());
		listSpecie.getItems().add(null);
		SelectEnclosure.getItems().add(null);
	}
	public void selectSpecie(ActionEvent event) {
		AnimalType selectedSpecie = (AnimalType) listSpecie.getSelectionModel().getSelectedItem();
		//SelectEnclosure.getItems().clear();
		//ArrayList<model.Enclosure> matchingEnclosures = new ArrayList();
		for (int i=0;i<enclosures.size();i++) {
			if (enclosures.get(i).getType()!=selectedSpecie)
				SelectEnclosure.getItems().remove(enclosures.get(i));
		}
		//SelectEnclosure.getItems().addAll(matchingEnclosures);
		listSpecie.getItems().add(null);
		SelectEnclosure.getItems().add(null);
	}
	public void Logout(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Login.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butLogout.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	@SuppressWarnings("deprecation")
	public void Add(ActionEvent event){
		Diet serving = new Diet();
		int hours = (int) comboHour.getSelectionModel().getSelectedItem();
		/*
		ArrayList<String> food = new ArrayList<String>();
		food.addAll(serving.getServingTypes());
		ArrayList<Time> time = new ArrayList<Time>();
		time.addAll(serving.getServingTimes());
		
		ObservableList<String> obslist1 = FXCollections.observableArrayList(food);
		listFood.setItems(obslist1);
		ObservableList<Time> obslist2 = FXCollections.observableArrayList(time);
		listTime.setItems(obslist2);*/
	}
	
	
	public void Remove(ActionEvent event) {
		
	}
	
	public void Accept(ActionEvent event) throws IOException {
		boolean correctInput = true;
		Animal animal = new Animal();
		model.Enclosure selectedEnclosure = (model.Enclosure)SelectEnclosure.getSelectionModel().getSelectedItem();
		if (Animal.checkName(txtName.getText()))
			animal.setName(txtName.getText());
		else {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Animal name input fail");
            alert.setHeaderText("Animal name consists only of letters and numbers");
            alert.show();
            correctInput = false;
		}
		if (correctInput) {
			AnimalType selectedSpecie = (AnimalType) listSpecie.getSelectionModel().getSelectedItem();
			
			if (selectedSpecie == selectedEnclosure.getType()) {
				animal.setType(selectedSpecie);
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Animal enclosure/specie error");
	            alert.setHeaderText("Animal specie doesn't match the enclosure");
	            alert.show();
	            correctInput = false;
			}
		}
		if (correctInput) {
			if (selectedEnclosure.isFull()) {
				Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Enclosure is full");
	            alert.setHeaderText("Selected enclosure is full, can't move there");
	            alert.show();
	            correctInput = false;
			}
		}
		if (correctInput) {
			selectedEnclosure.addAnimal(animal);
			FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Animals.fxml"));// create and load() view
			loader.load();
			Stage stage = (Stage) butAccept.getScene().getWindow();
			Scene scene = new Scene(loader.getRoot());
			stage.setScene(scene);
		}
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
		ArrayList<Integer> genNumbers = new ArrayList();
		for (int i=1;i<25;i++) {
			genNumbers.add(i);
		}
		comboHour.getItems().addAll(genNumbers);
		for (int i=25;i<61;i++) {
			genNumbers.add(i);
		}
		comboMinutes.getItems().addAll(genNumbers);
		/*ArrayList<Diet> diet = new ArrayList<Diet>();
		diet.add(serving);
		
		ObservableList<Diet> obslist = FXCollections.observableArrayList(diet);
		listFood.setItems(obslist);*/
	}
}
