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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends Main implements Initializable{
	@FXML
	private TextField txtUser; 
		
	@FXML 
	private PasswordField txtPass;
		
	@FXML  
	private Button butLogin;
		
	@FXML
	public void loginToUser(ActionEvent event) throws IOException {
		String temp = txtUser.getText().trim();
		System.out.println(temp+" "+currentUser.getUsername().toString());
		if (temp.equals(currentUser.getUsername())) {
			System.out.println("Success");
			FXMLLoader loader =  new FXMLLoader(getClass().getResource("/Main.fxml"));// create and load() view
			loader.load();
			Stage stage = (Stage) butLogin.getScene().getWindow();
			Scene scene = new Scene(loader.getRoot());
			stage.setScene(scene);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		butLogin.setOnAction(event -> {
			try {
				loginToUser(event);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
