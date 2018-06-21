package application;
 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicketsController implements Initializable{
	
	@FXML  
	private Button butLogout;
	
	@FXML  
	private Button butHome;
	
	@FXML
	private ListView purchaseList;
	
	@FXML
	private Label purchaseInfo;
	
	public void Logout(ActionEvent event) throws IOException {
		
	}
	
	public void Home(ActionEvent event) throws IOException {
			
	}
	
	public void selectTicket(ActionEvent event) throws IOException {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
