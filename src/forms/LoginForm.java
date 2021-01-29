package forms;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class LoginForm extends Application {
    public Scene scene_LoginForm;
    public Stage PrimaryStage_Login;
    /*"https://picsum.photos/200".*/
     private static final Background BACKGROUND_Fill = new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(10),new Insets(10) ));
        
    private Label CreateLabel_Login() {
        Label label_Login=new Label("Login Form");
        label_Login.prefWidth(100);
        label_Login.setUnderline(true);
        label_Login.setContentDisplay(ContentDisplay.CENTER);
        label_Login.setFont(Font.font(STYLESHEET_CASPIAN, FontPosture.ITALIC, 28));
        label_Login.setStyle("-fx-font-weight: bold;");
        return label_Login;
    }
    
        private Button CreateButtonLogin() {
        Button btnLogin=new Button("Login");
        btnLogin.setPadding(new Insets(15));
        btnLogin.setMaxWidth(150);
        
//       btnLogin.setStyle("-fx-background-color: linear-gradient(lightgreen, #be1d00);-fx-font-size:18px;font-weight:bold;-fx-background-radius: 10; -fx-background-insets: 0;\n" +
//             "    -fx-text-fill: white;");
        return btnLogin;
    }

       
    @Override
    public void start(Stage primaryStage) {
        PrimaryStage_Login=primaryStage;
       
        Label label_Login=CreateLabel_Login();
        Button btnLogin=CreateButtonLogin();
        
        ImageView imgView=new ImageView(new Image("https://picsum.photos/200"));
        imgView.setStyle("-fx-border-radius: 5;");
         
        Label lblUserName=new Label("Username:");
        lblUserName.setContentDisplay(ContentDisplay.CENTER);
        lblUserName.setFont(Font.font(STYLESHEET_CASPIAN, 18));
        lblUserName.setStyle("-fx-font-weight: bold;");
        
        TextField txttUserName=new TextField();
        txttUserName.setStyle("-fx-font-family: \"Quicksand\";-fx-border-color: orange;-fx-border-width:2;-fx-border-radius: 2;");
        Label lblPassword=new Label("Password:");
        lblPassword.setContentDisplay(ContentDisplay.CENTER);
        lblPassword.setFont(Font.font(STYLESHEET_CASPIAN, 18));
        lblPassword.setStyle("-fx-font-weight: bold;");
        
        TextField txttPassword=new TextField();
        txttPassword.setStyle("-fx-font-family: \"Quicksand\";-fx-border-color: orange;-fx-border-width:2;-fx-border-radius: 2;");
       
        
        GridPane loginForm=new GridPane();
       // loginForm.setGridLinesVisible(true);
        loginForm.setPadding(new Insets(20));//pading outside the gridPane
        loginForm.setVgap(30);
        loginForm.setHgap(20);
       // loginForm.setBackground(BACKGROUND_Fill);   
        loginForm.setAlignment(Pos.CENTER);
        loginForm.setHalignment(imgView, HPos.CENTER); // To align horizontally in the cell
  
        //loginForm.getColumnConstraints().add(new ColumnConstraints(200)); // column 1 is 100 wide
        loginForm.add(label_Login, 0, 0,2,1);
        loginForm.setHalignment(label_Login, HPos.CENTER); // To align horizontally in the cell

        loginForm.add(imgView,0,1,2,1);
        
        loginForm.add(lblUserName, 0, 2);
        loginForm.add(txttUserName, 1, 2);
        
        loginForm.add(lblPassword, 0, 3);
        loginForm.add(txttPassword, 1, 3);
        //loginForm.add(btnLogin, 1, 4);
        
         Button btnReg=new Button("Regiter");
         btnReg.setStyle("-fx-background-color: linear-gradient(lightgreen, #be1d00);-fx-font-size:18px;font-weight:bold;-fx-background-radius: 10; -fx-background-insets: 0;\n" +
                "-fx-text-fill: white;");
         loginForm.add(btnReg, 1, 5);
         
         Button btn_ReturnToMain=new Button("Return To Main");
         btn_ReturnToMain.setOnAction(e->{
                MainPage mainPage=new MainPage();
                mainPage.start(primaryStage);
        });
        
        loginForm.add(btn_ReturnToMain, 1, 4);
        
      // loginForm.getChildren().addAll(label,imgView,lblUserName,txttUserName,lblPassword,txttPassword);
       
      
      btnLogin.setOnAction(e->{
          System.out.println("btn clicked");
          String username=txttUserName.getText();
          String password=txttPassword.getText();
          CheckUserValidation(username,password);
      });
      
        scene_LoginForm=new Scene(loginForm,900,700);
        PrimaryStage_Login.setScene(scene_LoginForm);
        PrimaryStage_Login.setTitle("LOGIN Form");
        PrimaryStage_Login.show();
    }

    public  void CheckUserValidation(String Username,String Password){
        try {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation Alert");
            alert.setContentText("Welcome " + Username);
            Scanner scan=new Scanner(new File("users.txt"));
            while (scan.hasNextLine()) {  
                if(Username.equals(scan.hasNext()))
                    if(Password.equals(scan.hasNext()))
                     alert.showAndWait();
                    else{
                        alert=new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setContentText("Incorrect Password, please enter a valid one");
                    }
                else{
                    alert=new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("WARNING");
                    alert.setContentText("Incorrect Username, please enter a valid one");
                }
                    
                scan.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
