package session3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exer3 extends Application {
    
    private TextField CreateText() {
        TextField txt1=new TextField();
        txt1.setFont(Font.font("Courier",15.5));
        txt1.setAlignment(Pos.CENTER);
        txt1.setOpacity(1.5);
        return txt1;
    }
    
     private Label CreateLabel(TextField txt1) {
        Label lbl1=new Label("Enter Your Name", txt1);
        lbl1.setContentDisplay(ContentDisplay.BOTTOM);
        lbl1.setTextFill(Color.BLUE);
        return lbl1;
    }
     
    private ImageView InsertImages_External() throws FileNotFoundException {
        Image img_external=new Image("https://homepages.cae.wisc.edu/~ece533/images/fruits");
        ImageView imgview=new ImageView(img_external);
         imgview.setFitHeight(600);
         imgview.setFitWidth(600);
         return imgview;
    }

    private ImageView InsertImages_Local() throws FileNotFoundException {
      InputStream in = new FileInputStream("E:\\Computer Science_University\\Sem6- October Fall 2020\\Advanced Java Lab\\AJlab2021\\s.jpeg");
        Image img_Local=new Image(in);
        ImageView img_External=new ImageView(img_Local);
        img_External.setFitHeight(600);
         img_External.setFitWidth(600);
        return img_External;
    }
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
       
        TextField txt1=CreateText();
        Label lbl1=CreateLabel(txt1);
        ImageView imgview=InsertImages_External();
        ImageView imgview2=InsertImages_Local();
   
        HBox pane2=new HBox(10);
        pane2.getChildren().addAll(imgview,imgview2);
        pane2.setAlignment(Pos.CENTER);
        
        VBox pane=new VBox(15);
        pane.setPadding(new Insets(20));
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(lbl1,txt1,pane2);
        pane.setStyle("-fx-background-color:lightBlue");
        
        Scene scene = new Scene(pane, 300, 250);
        scene.setCursor(Cursor.DISAPPEAR);
        
        primaryStage.setTitle("Sample element with simple style FULL SCREEN Display");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    

    public static void main(String[] args) {
        launch(args);
    }
    
}
