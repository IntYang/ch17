




package ch17.exam42;

//2017.04.21



import ch17.exam41.*;
import ch17.exam40.*;
import ch17.exam39.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    //start 재정의 
    @Override
    public void start(Stage primaryStage) throws Exception {
        //AnchorPane객체가 나옴
        Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
        
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("창제목");
        
        
       
        primaryStage.show();
    }
    
    //main에서 launch시키기
    public static void main(String[] args) {
        launch(args);
    }
    
}
