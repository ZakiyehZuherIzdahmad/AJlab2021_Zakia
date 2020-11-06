package session2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Exer2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
          
        Label lbl1=new Label("First Label");
        TextField txt1=new TextField("Enter A Text Here");
        CheckBox chbx=new CheckBox("select one or more ");
        RadioButton rdb=new RadioButton("Choose an option");
        
        FlowPane pane1=new FlowPane();
        pane1.getChildren().addAll(lbl1,txt1,chbx,rdb);
              
       Scene scene1=new Scene(pane1,400,400);
       primaryStage.setScene(scene1);
       primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
