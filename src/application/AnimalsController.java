package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Animal;
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
	
	public void EditAnimal(ActionEvent event) {
		
	}
	
	public void Remove(ActionEvent event) {
		
	} 
	
	public void Info(ActionEvent event) {
		Animal animal = (Animal) listAnimals.getSelectionModel().getSelectedItem();
		for(int i = 0; i < enclosures.size(); i++) {
			if (enclosures.contains(animal)) {
				txtID.setText(String.valueOf(animal.getID()));
				txtName.setText(String.valueOf(animal.getName()));  
				txtSpecie.setText(String.valueOf(animal.getType())); 
				txtEnclosure.setText(String.valueOf(animal.getName())); 
				txtDate.setText(animal.getDateAdded().toGMTString()); 
			}
		}
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		///listEnclosures.setItems((ObservableList) enclosures);
		///ObservableList<Animal> obslist = FXCollections.observableArrayList(enclosures);
		///listEnclosures.setItems(obslist);
	}
}
