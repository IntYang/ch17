
package ch17.exam42;

import ch17.exam41.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class RootController implements Initializable {

	 @FXML
	 private Button btnLogin;
	 
	 @FXML
	 private StackPane stackPane ; // 사용하기 위해서는 사용접근자 및, 참조도얻어야 해서
		 
	 public static StackPane rootPane;

	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
			rootPane = stackPane;
			btnLogin.setOnAction(e->handleBtnLogin(e));
	 }	 

	 private void handleBtnLogin(ActionEvent e) {
			try{
				 Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
				 // StackPane 얻기
				 stackPane.getChildren().add(parent);
				 
				 
			}
			catch(IOException ex){
				 ex.printStackTrace();
			}
	 }
	 
}
