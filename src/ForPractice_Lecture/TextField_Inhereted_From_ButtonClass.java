package ForPractice_Lecture;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextField_Inhereted_From_ButtonClass extends ButtonClass {
    
    
    protected HBox Create_Two_Buttons(){
        
    //get pane from previous class to add new element to it
    HBox pane=super.Create_Two_Buttons();
    
    HBox paneForTextField=new HBox(30);
    paneForTextField.setPadding(new Insets(20));
    
    Label lbl=new Label("Enter Your Message");
    lbl.setAlignment(Pos.CENTER);
    
    TextField tf=new TextField();
    //tf.setPrefColumnCount(20);
    tf.setStyle("-fx-text-fill: green");
    
    paneForTextField.getChildren().add(tf);
    paneForTextField.setAlignment(Pos.CENTER);

        VBox AllPanes=new VBox(20);
        AllPanes.getChildren().addAll(lbl,tf,pane);
        
       //HBX To return all elemt and because the override ried method has HBox return type
       HBox finalPane=new HBox(30);
       finalPane.getChildren().add(AllPanes);
       
    return finalPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
