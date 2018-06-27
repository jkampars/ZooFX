package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Animal;
import model.Diet;
import model.Enclosure;

public class AnimalsController extends Main implements Initializable{
	 
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
	
	public void Home(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Main.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butHome.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void AddAnimal(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/AddAnimal.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butAddAnimal.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void EditAnimal(ActionEvent event) throws IOException {
		Animal animal = (Animal) listAnimals.getSelectionModel().getSelectedItem();
		
		if (listAnimals.getSelectionModel().getSelectedItem()!=null) {
			FXMLLoader loader =  new FXMLLoader(getClass().getResource("/EditAnimal.fxml"));// create and load() view
			loader.load();
			EditAnimalController mainController = loader.<EditAnimalController>getController();
	        mainController.showSelectedAnimal(animal);;
			Stage stage = (Stage) butAddAnimal.getScene().getWindow();
			Scene scene = new Scene(loader.getRoot());
			stage.setScene(scene);
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("No animal selected");
            alert.setHeaderText("Please select an animal you wish to edit");
            alert.show();
		}
	}
	
	public void Remove(ActionEvent event) throws IOException {
		Animal animal = (Animal) listAnimals.getSelectionModel().getSelectedItem();
		for(int i = 0; i < enclosures.size(); i++) {
			if (enclosures.get(i).getAnimals().contains(animal)) {  
				enclosures.get(i).getAnimals().remove(animal); 

				FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Animals.fxml"));// create and load() view
				loader.load();
				Stage stage = (Stage) butRemoveAnimal.getScene().getWindow();
				Scene scene = new Scene(loader.getRoot());
				stage.setScene(scene);
			}
		}
	} 
	
	public void Info(MouseEvent event) {
		Animal animal = (Animal) listAnimals.getSelectionModel().getSelectedItem();
		for(int i = 0; i < enclosures.size(); i++) {
			if (enclosures.get(i).getAnimals().contains(animal)) {
				txtID.setText(String.valueOf(animal.getID()));
				txtName.setText(String.valueOf(animal.getName()));  
				txtSpecie.setText(String.valueOf(animal.getType())); 
				txtEnclosure.setText(String.valueOf(enclosures.get(i).toString())); 
				txtDate.setText(animal.getDateAdded().toGMTString()); 
 
				ObservableList<Diet> obslist1 = FXCollections.observableArrayList(animal.getDiet());
				food.setItems(obslist1); 
			}
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ArrayList<Animal> allAnimals = new ArrayList<Animal>();
		for(int i = 0; i < enclosures.size(); i++) {
			allAnimals.addAll(enclosures.get(i).getAnimals());   
		}
		
		ObservableList<Animal> obslist = FXCollections.observableArrayList(allAnimals);
		listAnimals.setItems(obslist);
	}
}
