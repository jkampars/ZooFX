package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.UserType;

public class LoginController extends Main {
	@FXML
	private TextField txtUser; 
		
	@FXML 
	private PasswordField txtPass;
		
	@FXML  
	private Button butLogin;
		
	@FXML
	public void loginToUser(ActionEvent event) throws IOException {
		for (int i=0;i<users.size();i++) {	
			if (txtUser.getText().equals(users.get(i).getUsername()) && txtPass.getText().equals(users.get(i).getPassword())) {
				if (users.get(i).getUserType()==UserType.NOUSER) {
					Alert alert = new Alert(AlertType.ERROR);
		            alert.setTitle("No user rights");
		            alert.setHeaderText("This user has not been granted any rights");
		            alert.setContentText("Please contact a system administrator");
		            alert.show();
				}
				else if (users.get(i).getUserType()==UserType.USER) {
					currentUser = users.get(i);
					FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Main.fxml"));// create and load() view
					loader.load();
					Stage stage = (Stage) butLogin.getScene().getWindow();
					Scene scene = new Scene(loader.getRoot());
					stage.setScene(scene);
				}
				else if (users.get(i).getUserType()==UserType.ADMIN) {
					currentUser = users.get(i);
					FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Main.fxml"));// create and load() view
					loader.load();
					Stage stage = (Stage) butLogin.getScene().getWindow();
					Scene scene = new Scene(loader.getRoot());
					stage.setScene(scene);
				}
			}
		}
	}

}
