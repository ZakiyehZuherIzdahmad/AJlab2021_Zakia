package forms;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainPage extends Application {
    
    Login_Form logForm=new  Login_Form();
    User_Registration_Form regForm;
    Scene SceneMain;
    Stage PrimaryStageMain;
    public MainPage() {
        this.regForm = new User_Registration_Form();
    }

   
            
    @Override
    public void start(Stage primaryStage) {
        PrimaryStageMain=primaryStage;
         ImageSlider imageSlider = new ImageSlider();
         imageSlider.setOpacity(0.7);
         
//        imageSlider.setMinWidth(400);
//        imageSlider.setMinHeight(400);

        Button btn = new Button("Sign in");
        Button btn2 = new Button("Sign Up");
        
        btn.setMinHeight(100);
        btn.setMinWidth(100);
        btn.setStyle("-fx-background-color:linear-gradient(#ffd65b, #e68400),linear-gradient(#ffef84, #f2ba44),linear-gradient(#ffea6a, #efaa22),linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n" +
"linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-insets: 0,1,2,3,0;-fx-text-fill: black;-fx-font-weight: bold;-fx-font-size: 18px;\n" +
"    -fx-padding: 10 20 10 20;");
        
         btn2.setStyle("-fx-background-color:linear-gradient(#ffd65b, #e68400),linear-gradient(#ffef84, #f2ba44),linear-gradient(#ffea6a, #efaa22),linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n" +
"linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-insets: 0,1,2,3,0;-fx-text-fill: black;-fx-font-weight: bold;-fx-font-size: 18px;\n" +
"-fx-padding: 10 20 10 20;");
         
        btn2.setMinHeight(100);
        btn2.setMinWidth(100);
       
        
        HBox hbButton = new HBox(20);
        hbButton.getChildren().addAll(btn,btn2);
        hbButton.setAlignment(Pos.CENTER);
        //hbButton.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.DARKSEAGREEN, new CornerRadii(10),new Insets(10))));
        
        StackPane stackpane=new StackPane();
        stackpane.getChildren().addAll(imageSlider,hbButton);
        stackpane.setBorder(new Border(new BorderStroke(Color.ORANGE, BorderStrokeStyle.NONE, new CornerRadii(15), new BorderWidths(0))));
        SceneMain = new Scene(stackpane,400,400);
       
        primaryStage.setTitle("Main Page");
        primaryStage.setScene(SceneMain);
        primaryStage.show();
        
        btn.setOnAction(e->{
                primaryStage.hide();
                logForm.start(primaryStage);
        });
        
        btn2.setOnAction(e->{
         primaryStage.hide();
         this.regForm.start(primaryStage);
        
        });
        

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
