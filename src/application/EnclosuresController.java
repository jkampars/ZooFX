package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import model.Enclosure;

public class EnclosuresController extends Main implements Initializable{
	
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
	private Text txtName;
	
	@FXML  
	private Text txtType;
	
	@FXML  
	private Text txtCapacity;
	
	@FXML  
	private Text txtID;
	
	@FXML  
	private ListView listEnclosures;
	
	@FXML  
	private ListView listAnimals;
	
	public void ShowEnclosures(MouseEvent event) {
		Enclosure selected = (Enclosure) listEnclosures.getSelectionModel().getSelectedItem();
		txtName.setText(selected.getName());
		txtType.setText(selected.getType().name());
		txtCapacity.setText(selected.getCurrent_capacity()+"/"+selected.getMAX_CAPACITY());
		txtID.setText(Integer.toString(selected.getId()));
		
		ObservableList<Animal> obslist = FXCollections.observableArrayList(selected.getAnimals());
		listAnimals.setItems(obslist);
	}
	
	public void SelectAnimal(MouseEvent event) {
		
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
	
	public void AddEnclosure(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/AddEnclosure.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butAddEnclosure.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void RemoveEnclosure(ActionEvent event) throws IOException {
		if(listEnclosures.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Remove enclosure error");
	        alert.setHeaderText("No enclosure selected");
	        alert.setContentText("Please select an enclosure to remove it");
	        alert.show();
		}
		else {
			if(enclosures.get(enclosures.indexOf(listEnclosures.getSelectionModel().getSelectedItem())).animalsIsEmpty() == true){
				enclosures.remove(listEnclosures.getSelectionModel().getSelectedItem());
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Remove enclosure error");
		        alert.setHeaderText("Cant remove enclosure with animals in it");
		        alert.setContentText("Please remove animals from enclosure to remove it");
		        alert.show();
			}
			FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Enclosures.fxml"));// create and load() view
			loader.load();
			Stage stage = (Stage) butRemoveEnclosure.getScene().getWindow();
			Scene scene = new Scene(loader.getRoot());
			stage.setScene(scene);
		}
	}
	
	public void EditEnclosure(ActionEvent event) throws IOException {
		if(listEnclosures.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Edit enclosure error");
            alert.setHeaderText("No enclosure selected");
            alert.setContentText("Please select an enclosure to edit it");
            alert.show();
		}
		else if(!((Enclosure) listEnclosures.getSelectionModel().getSelectedItem()).isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Edit enclosure error");
            alert.setHeaderText("Enclosure is not empty");
            alert.setContentText("Please empty the enclosure to edit it");
            alert.show();
		}
		else {
			Enclosure enclosure = (Enclosure) listEnclosures.getSelectionModel().getSelectedItem();
			FXMLLoader loader =  new FXMLLoader(getClass().getResource("/EditEnclosure.fxml"));// create and load() view
			loader.load();
			Stage stage = (Stage) butEditEnclosure.getScene().getWindow();
			Scene scene = new Scene(loader.getRoot());
			stage.setScene(scene);
		}
	}
	
	public void MoveAnimal(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/MoveAnimal.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butMoveAnimal.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	

	public void RemoveAnimal1(ActionEvent event) {
		
	}
	public void RemoveAnimal(ActionEvent event) {
		Animal animal = (Animal) listAnimals.getSelectionModel().getSelectedItem();
		for(int i = 0; i < enclosures.size(); i++) {
			if (enclosures.get(i).getAnimals().contains(animal)) {
				enclosures.get(i).getAnimals().remove(animal);

				
				
				
				//te vajag kaut ko citu reinitialize!!!
				ArrayList<Animal> animals = new ArrayList<Animal>();
				animals.addAll(((Enclosure) listEnclosures.getSelectionModel().getSelectedItem()).getAnimals());
				
				
				ObservableList<Animal> obslist = FXCollections.observableArrayList(animals);
				listAnimals.setItems(obslist);
				
				Enclosure selected = (Enclosure) listEnclosures.getSelectionModel().getSelectedItem();
				txtName.setText(selected.getName());
				txtType.setText(selected.getType().name());
				txtCapacity.setText(selected.getCurrent_capacity()+"/"+selected.getMAX_CAPACITY());
				txtID.setText(Integer.toString(selected.getId()));
				
				ObservableList<Animal> obslist2 = FXCollections.observableArrayList(selected.getAnimals());
				listAnimals.setItems(obslist2);
				
				
				break;
			}
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		///listEnclosures.setItems((ObservableList) enclosures);
		ObservableList<Enclosure> obslist = FXCollections.observableArrayList(enclosures);
		listEnclosures.setItems(obslist);
	}
}
