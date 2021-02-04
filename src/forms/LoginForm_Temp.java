/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class LoginForm_Temp extends Application {
    Alert alert=new Alert(Alert.AlertType.INFORMATION);
    boolean flag=false;
    @Override
    public void start(Stage primaryStage) {
      Label lblUserName=new Label("Username:");
      Label lblPassword=new Label("Password:");
      TextField txttPassword=new TextField();
      TextField txttUserName=new TextField();

      Button btnlogin=new Button("Login");
      
      btnlogin.setOnAction(e->{
          //System.out.println("btn clicked");
          String username=txttUserName.getText();
          String password=txttPassword.getText();
          
          if (username.equals("")) {          
                alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING");
                alert.setContentText("Username is empty , please enter a valid one");
                alert.showAndWait();
           }
          
          else if (!(username.equals("")) && password.equals("")) {          
                alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING");
                alert.setContentText("password is empty , please enter a valid one");
                alert.showAndWait();
           }
          
          else 
              CheckUserValidation(username,password);
      });
      VBox root=new VBox(10);
      root.getChildren().addAll(lblUserName,txttUserName,lblPassword,txttPassword,btnlogin);
      root.setSpacing(20);
      root.setAlignment(Pos.CENTER);
      Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public  void CheckUserValidation(String Username,String Password){
        try {
            alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation Alert");
            alert.setContentText("Welcome " + Username);
            Scanner scan=new Scanner(new File("users.txt"));
            
            while (scan.hasNext()) {  
                while(Username.equals(scan.next())){
                    if(Password.equals(scan.next())){
                     alert.showAndWait();
                    flag=true;
                    break;
                    }
                    else{
                        alert=new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setContentText("Incorrect Password, please enter a valid one");
                        alert.showAndWait();
                        break;
                    } 
 
                }
                                     
                scan.nextLine();
           } 
            
            if(flag==false){
                    alert=new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("WARNING");
                    alert.setContentText("Incorrect Username, please enter a valid oneeeeeeeeeeee");
                    alert.showAndWait();}

 scan.close();
            }
        
 catch (FileNotFoundException ex) {
     System.out.println(StackTraceElement.class);        }
        
    }
    
}
