package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.Checksum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.User;
import model.UserType;

public class AddUserController extends Main implements Initializable{
	
	@FXML  
	private Button butLogout;
	
	@FXML  
	private Button butHome;
	
	@FXML  
	private Button butAccept;
	
	@FXML  
	private Button butCancel;
	
	@FXML  
	private TextField txtUsername;
	
	@FXML  
	private PasswordField txtPassword;
	
	@FXML  
	private ComboBox listType;
	
	public void Home(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Main.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butHome.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Logout(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Login.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butLogout.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}
	
	public void Accept(ActionEvent event) throws IOException {
		boolean failCheck = true;
		if (!User.checkUsername(txtUsername.getText()) || txtUsername.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Name input fail");
            alert.setHeaderText("Name input fail");
            alert.show();
			failCheck = false;
		}
		else if (!failCheck || !User.checkPassword(txtPassword.getText()) || txtPassword.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Password fail");
            alert.setHeaderText("Password fail");
            alert.show();
			failCheck = false;
		}
		else if (failCheck && !(listType.getValue()==null)) {
			User addUser = new User(txtUsername.getText(), txtPassword.getText());
			addUser.setUserType((UserType)listType.getSelectionModel().getSelectedItem());
			users.add(addUser);
			FXMLLoader loader =  new FXMLLoader(getClass().getResource("/ManageUsers.fxml"));// create and load() view
			loader.load();
			Stage stage = (Stage) butHome.getScene().getWindow();
			Scene scene = new Scene(loader.getRoot());
			stage.setScene(scene);
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("User type fail");
            alert.setHeaderText("User type fail");
            alert.show();
		}
	}
	
	public void Cancel(ActionEvent event) throws IOException {
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/ManageUsers.fxml"));// create and load() view
		loader.load();
		Stage stage = (Stage) butHome.getScene().getWindow();
		Scene scene = new Scene(loader.getRoot());
		stage.setScene(scene);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		listType.getItems().addAll(UserType.values());
	}
}
