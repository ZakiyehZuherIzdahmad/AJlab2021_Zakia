package forms;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Registration_Form extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane form_Reg = new GridPane();
        form_Reg.setPadding(new Insets(20));
        form_Reg.setHgap(20);
        form_Reg.setVgap(20);
       // form_Reg.setGridLinesVisible(true);
        
        Text txt_Name=new Text("Name:");
        Text txt_Email=new Text("Email:");
        Text txt_Phone=new Text("Phone:");
        Text txt_Password=new Text("Password:");
        Text txt_Confirm=new Text("Confirm:");
        Text txt_Country=new Text("Country:");
        Text txt_Gender=new Text("Gender:");
        Text txt_Language=new Text("Language:");
        Text txt_About=new Text("About:");
        Text txt_Alert=new Text();
        txt_Alert.setFill(Color.RED);
        
        TextField TF_Name=new TextField();
        TextField TF_Email=new TextField();
        TextField TF_Phone=new TextField();
        PasswordField TF_Password=new PasswordField();
        PasswordField TF_Confirm=new PasswordField();
        
        TF_Name.setPrefColumnCount(50);
        ComboBox<String> Cmb_Country=new ComboBox<>();
        Cmb_Country.setPromptText("Select...");
        Cmb_Country.getItems().addAll("Afghanistan","Albania","Algeria","Andorra","Angola","Antigua","Barbuda","Argentina",
                                      "Belarus","Belgium","Belize","Benin (Dahomey)","Bolivia");
                
        RadioButton rdb_Female=new RadioButton("Female");
        RadioButton rdb_Male=new RadioButton("Male");
        
        ToggleGroup grp_Gender=new ToggleGroup();
        rdb_Female.setToggleGroup(grp_Gender);
        rdb_Male.setToggleGroup(grp_Gender);
        
        HBox HB_Rdb=new HBox(5);
        HB_Rdb.getChildren().addAll(rdb_Female,rdb_Male);
                
        CheckBox chkBx_Arabic=new CheckBox("Arabic");
        CheckBox chkBx_English=new CheckBox("English");
        CheckBox chkBx_Spanish=new CheckBox("Spanish");
        
        HBox HB_chkBx=new HBox(5);
        HB_chkBx.getChildren().addAll(chkBx_Arabic,chkBx_English,chkBx_Spanish);
        
        TextArea TA_AboutYou=new TextArea();
        TA_AboutYou.setPromptText("Your Biography....");
        
        Button btn_Register=new Button("Register");
        btn_Register.setPrefWidth(500);
        
        btn_Register.setOnAction(e->{
                    txt_Alert.setText("");
                    boolean hasCap=false,hasLow=false,hasDig=false,hasSpecialChar=false,FLAG=true;
                    char c; 

                    //Validate Name
                    if(!(TF_Name.getText().matches("^[a-zA-Z]*$"))){
                          txt_Alert.setText(txt_Alert.getText()+"\n Name must not have digits");
                          FLAG=false;}
                    
                    //Validate Email
                    if(!(TF_Email.getText().contains("@") && TF_Email.getText().contains("."))){
                          txt_Alert.setText(txt_Alert.getText()+"\n Valid Email (it has @ and dot characters).");
                          FLAG=false;}
                    
                    //Validate Phone Number
                    if(!(TF_Phone.getText().matches("[0-9]") || TF_Phone.getText().length()==8)){
                           txt_Alert.setText(txt_Alert.getText()+"\n Invalid Phone Number (8 digit only)");
                           FLAG=false;}
                   
                   //Validate Strong Password
                    if(((TF_Password.getText().length()>=8))){
                       for(int i=0;i<TF_Password.getText().length();i++){
                            c=TF_Password.getText().charAt(i);
                            if(Character.isDigit(c))
                                hasDig=true;
                            if(Character.isUpperCase(c))
                                hasCap=true;
                            if(Character.isLowerCase(c))
                                hasLow=true;
                            if(TF_Password.getText().contains("[!@#$%&*()_+=|<>?{}\\[\\]~-]"))
                                hasSpecialChar=true;
                            /*OR
                            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
                            Matcher hasSpecial = special.matcher(TF_Password.getText());*/
                       }} 
                        if(hasCap==false && hasLow==false && hasDig==false && hasSpecialChar==false) {
                           txt_Alert.setText(txt_Alert.getText()+"\n Password should Contains at least one capital letter, one small letter, one digit and minimum length is 8");   
                            FLAG=false;}

                     //Validate Confirm Password
                        if (!(TF_Confirm.getText().equals(TF_Password.getText()))){ 
                               txt_Alert.setText(txt_Alert.getText()+"\n Password doesn't match");  
                               FLAG=false;}

                        //Validate Cmbx
                        if(Cmb_Country.getSelectionModel​().isEmpty()){
                               txt_Alert.setText(txt_Alert.getText()+"\n Country: must be selected"); 
                               FLAG=false;}

                        if (!(TA_AboutYou.getText().length()>=50)){
                                txt_Alert.setText(txt_Alert.getText()+"\n About You: at least 50 characters.");
                                FLAG=false;}
                        
                        //If All Field Validated
                        if(FLAG==true){
                            Alert a = new Alert(AlertType.CONFIRMATION, "", new ButtonType("OK"));
                            a.setTitle("Confirm Registration");
                            a.setHeaderText("Succesfully registerd");
                           // a.setContentText("Content text");
                            a.showAndWait();}
          });
        
        form_Reg.addColumn(0, txt_Name,txt_Email,txt_Phone,txt_Password,txt_Confirm,txt_Country,txt_Gender,txt_Language,txt_About);
        form_Reg.addColumn(1, TF_Name,TF_Email,TF_Phone,TF_Password,TF_Confirm,Cmb_Country);
        form_Reg.add(HB_Rdb, 1, 6);
        form_Reg.add(HB_chkBx, 1, 7);
        form_Reg.add(TA_AboutYou, 1, 8);
        form_Reg.add(btn_Register, 0, 9, 2, 1);
        form_Reg.add(txt_Alert, 0, 10, 2, 1);
        
        Scene scene = new Scene(form_Reg, 700, 700);
        primaryStage.setTitle("Registration_Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}