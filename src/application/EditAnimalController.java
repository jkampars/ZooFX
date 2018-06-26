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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Animal;
import model.AnimalType;

public class EditAnimalController extends Main implements Initializable{
	
	private Animal selectedAnimal;
	
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
	private Text txtSpecie;

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
	
	@FXML
	private Text txtId;
	
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
	
	public void Accept(ActionEvent event) throws IOException {
		boolean correctInput = true;
		if (Animal.checkName(txtName.getText()))
			selectedAnimal.setName(txtName.getText());
		else {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Animal name input fail");
            alert.setHeaderText("Animal name consists only of letters and numbers");
            alert.show();
            correctInput = false;
		}
		if (correctInput) {
			model.Enclosure selectedEnclosure = (model.Enclosure)SelectEnclosure.getSelectionModel().getSelectedItem();
			if (selectedEnclosure == selectedAnimal.getEnclosure()) {
				
			}
			else if (!selectedEnclosure.isFull())
				selectedAnimal.moveTo((model.Enclosure) SelectEnclosure.getSelectionModel().getSelectedItem());
			else {
				Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Enclosure is full");
	            alert.setHeaderText("Selected enclosure is full, can't move there");
	            alert.show();
	            correctInput = false;
			}
		}
		if (correctInput) {
			FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Animals.fxml"));// create and load() view
			loader.load();
			Stage stage = (Stage) butCancel.getScene().getWindow();
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
	
	public void showSelectedAnimal(Animal input) {
		txtName.setText(input.getName());
		//txtSpecie.setText(input.getType().toString());
		txtId.setText(Integer.toString(input.getID()));
		for (int i=0;i<enclosures.size();i++){
			for (int j=0;j<enclosures.get(i).getAnimals().size();j++) {
				if (txtId.getText().equals(Integer.toString(enclosures.get(i).getAnimals().get(j).getID())))
					selectedAnimal=enclosures.get(i).getAnimals().get(j);
			}
		}
		txtSpecie.setText(input.getType().toString());
		for (int i=0;i<enclosures.size();i++) {
			if (input.getType()==enclosures.get(i).getType())
				SelectEnclosure.getItems().add(enclosures.get(i));
		}
		for (int i=0;i<enclosures.size();i++) {
			if (enclosures.get(i).getAnimals().contains(input))
				SelectEnclosure.getSelectionModel().select(enclosures.get(i));
		}
		//System.out.println(selectedAnimal);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		for (int i=0;i<enclosures.size();i++){
			for (int j=0;j<enclosures.get(i).getAnimals().size();j++) {
				if (txtId.getText().equals(Integer.toString(enclosures.get(i).getAnimals().get(j).getID())))
					selectedAnimal=enclosures.get(i).getAnimals().get(j);
			}
		}
		//System.out.println(txtName.getText());
	}
}
