
package ch17.exam41;
//2017.04.21 수업내용
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class LoginController implements Initializable {

	 @FXML
	 private BorderPane login;
	 @FXML
	 private Button btnMain;

	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
			btnMain.setOnAction(e->handleBtnMain(e));
	 }	 

	 private void handleBtnMain(ActionEvent e) {
				// how1
				 //RootController.rootPane.getChildren().remove(1);
				 
				 //how2
					 StackPane rootPane = (StackPane) btnMain.getScene().getRoot();
				// rootPane.getChildren().remove(login);
				 
				 login.setTranslateX(1); // 초기값 350
				 KeyValue keyValue = new KeyValue(login.opacityProperty(),0); // Fade out
				 KeyFrame keyFrame = new KeyFrame(
															Duration.millis(500),
															(event)->{ rootPane.getChildren().remove(login);},
															keyValue
													 ); // 애니메이션 진행 시간
				 Timeline timeline = new Timeline();// 타임라은은 한 개만 만들어도 됨
				 timeline.getKeyFrames().add(keyFrame); 
				 timeline.play();
				 
				 
				 
				 
				 
				 
	 }
	 
}
