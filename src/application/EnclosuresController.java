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
		Stage stage = (Stage) butLogout.getScene().getWindow();
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
	
	public void RemoveEnclosure(ActionEvent event) {
		
	}
	
	public void EditEnclosure(ActionEvent event) {
		
	}
	
	public void MoveAnimal(ActionEvent event) {
		
	}
	

	public void RemoveAnimal(ActionEvent event) {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		///listEnclosures.setItems((ObservableList) enclosures);
		ObservableList<Enclosure> obslist = FXCollections.observableArrayList(enclosures);
		listEnclosures.setItems(obslist);
	}
}
