package ForPractice_Lecture;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class ButtonClass extends Application {
    
     protected HBox Create_Two_Buttons() {
        Button btnLeft=new Button("Leftt", new ImageView("file:///E:\\Computer Science_University\\Sem6- October Fall 2020\\Advanced Java Lecture\\AdvancedJavaLecture_Exer\\ImagesForButton\\left.jpg  "));
        Button btnRight=new Button("Right", new ImageView("file:///E:\\Computer Science_University\\Sem6- October Fall 2020\\Advanced Java Lecture\\AdvancedJavaLecture_Exer\\ImagesForButton\\right.png"));
        
        /*btnLeft.setStyle("-fx-border-color: yellow");
        btnRight.setStyle("-fx-border-color: yellow");
        // btnLeft.setStyle("-fx-text-fill: red");
        btnLeft.setStyle("-fx-font-weight: bold");
        btnRight.setStyle("-fx-font-weight: bold");
        btnLeft.setPadding(new Insets(20));
        btnRight.setPadding(new Insets(20));
        */
        HBox paneForButton=new HBox(30);
        
        paneForButton.getChildren().addAll(btnLeft,btnRight);
        paneForButton.setAlignment(Pos.CENTER);
        paneForButton.setPadding(new Insets(20));
        //paneForButton.setStyle("-fx-background-color:LightBlue");
        
        return paneForButton;
    }

    @Override
    public void start(Stage primaryStage) {
      
   /*First way
        
    HBox paneForButton=Create_Two_Buttons();
    Scene scene1=new Scene(paneForButton,400,200);
    */
   
    Scene scene1=new Scene(Create_Two_Buttons(),700,700);//take the pane Direct;y from the method
   
    primaryStage.setScene(scene1);
    primaryStage.setTitle("HBox with Button And Text");
    primaryStage.show();
    }

  public static void main(String[] args) {
        launch(args);
    }
    
}
