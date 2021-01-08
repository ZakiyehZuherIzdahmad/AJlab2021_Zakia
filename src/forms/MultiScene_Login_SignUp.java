package forms;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MultiScene_Login_SignUp extends Application {
            Button btn = new Button("Sign in");
            Button btn2 = new Button("Sign Up");
            Button btnReg=new Button("Don't have an account yet?");
            Button btn_Already=new Button("Already have an account?"); 
            Label label_Login=CreateLabel_Login();
            Button btnLogin=CreateButtonLogin();  
            private static final Background BACKGROUND_Fill = new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(10),new Insets(10) ));
            boolean hasCap=false,hasLow=false,hasDig=false,hasSpecialChar=false,FLAG=true;
            char c; 
            GridPane form_Reg;
     
    private HBox MainButtons() {
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
        return hbButton;
    }
      
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
        btnLogin.setMaxWidth(75);
        
        btnLogin.setStyle("-fx-background-color: linear-gradient(lightgreen, #be1d00);-fx-font-size:18px;font-weight:bold;-fx-background-radius: 10; -fx-background-insets: 0;\n" +
                "    -fx-text-fill: white;");
        return btnLogin;
    }
        
    private void Validate_About_You(TextArea TA_AboutYou, Text txt_Alert) {
        if (!(TA_AboutYou.getText().length()>=50)){
            txt_Alert.setText(txt_Alert.getText()+"\n About You: at least 50 characters.");
            FLAG=false;}
         else
            FLAG=true;
    }
    
    private void Validate_Cmbx(ComboBox<String> Cmb_Country, Text txt_Alert) {
        if(Cmb_Country.getSelectionModel​().isEmpty()){
            txt_Alert.setText(txt_Alert.getText()+"\n Country: must be selected");
            FLAG=false;}
         else
            FLAG=true;
    }

    private void Validate_Confirm_Password(PasswordField TF_Confirm, PasswordField TF_Password, Text txt_Alert) {
        if (!(TF_Confirm.getText().equals(TF_Password.getText()))){
            txt_Alert.setText(txt_Alert.getText()+"\n Password doesn't match");
            FLAG=false;}
         else
            FLAG=true;
    }

    private void Validate_Strong_Password(PasswordField TF_Password, Text txt_Alert) {
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
            txt_Alert.setText(txt_Alert.getText()+"\n Password should Contains at least:\n \tone capital letter, \n \tone small letter, \n\tone digit and minimum length is 8");
            FLAG=false;}
         else
            FLAG=true;
    }

    private void Validate_Phone_Number(TextField TF_Phone, Text txt_Alert) {
        if(!(TF_Phone.getText().matches("[0-9]") || TF_Phone.getText().length()==8)){
            txt_Alert.setText(txt_Alert.getText()+"\n Invalid Phone Number (8 digit only)");
            FLAG=false;}
         else
            FLAG=true;
    }

    private void Validate_Email(TextField TF_Email, Text txt_Alert) {
        if(!(TF_Email.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com"))){
            txt_Alert.setText(txt_Alert.getText()+"\n Valid Email (it has @ and dot characters).");
            FLAG=false;}
         else
            FLAG=true;
    }
    
    private void Validate_Name(TextField TF_Name, Text txt_Alert) {
        txt_Alert.setText("");
        if(!(TF_Name.getText().matches("^[a-zA-Z]*$"))){
            txt_Alert.setText(txt_Alert.getText()+"\n Enter valied Name... must not have digits");
            FLAG=false;}
        else
            FLAG=true;
        
    }
     
    @Override
    public void start(Stage primaryStage) {
        ImageSlider imageSlider = new ImageSlider();
        imageSlider.setOpacity(0.7);
        HBox hbButton = MainButtons();
        
        StackPane stackpane=new StackPane();
        stackpane.getChildren().addAll(imageSlider,hbButton);
        stackpane.setBorder(new Border(new BorderStroke(Color.ORANGE, BorderStrokeStyle.NONE, new CornerRadii(15), new BorderWidths(0))));
        Scene scene = new Scene(stackpane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btn.setOnAction(e->{primaryStage.setScene(LoginFormScene());});
        btn_Already.setOnAction(e->{primaryStage.setScene(LoginFormScene());});
        btn2.setOnAction(e->{primaryStage.setScene(Reg_Form_Scene());});
        btnReg.setOnAction(e->{primaryStage.setScene(Reg_Form_Scene());});
  
    }

    private Scene Reg_Form_Scene() {
         form_Reg = new GridPane();
        form_Reg.setPadding(new Insets(20));
        form_Reg.setHgap(10);
        form_Reg.setVgap(20);
        // form_Reg.setGridLinesVisible(true);
        
        Scene scene_Reg = new Scene(form_Reg, 700, 750);
        
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
        btn_Register.setPrefWidth(scene_Reg.getWidth());
        
        btn_Register.setOnAction(e->{
            txt_Alert.setText("");
            if (!(TF_Name.getText().equals("")))
                Validate_Name(TF_Name, txt_Alert);
            else {
                txt_Alert.setText(txt_Alert.getText()+"\n Enter valide Name.");
            }
            Validate_Email(TF_Email, txt_Alert);
            Validate_Phone_Number(TF_Phone, txt_Alert);
            Validate_Strong_Password(TF_Password, txt_Alert);
            Validate_Confirm_Password(TF_Confirm, TF_Password, txt_Alert);
            Validate_Cmbx(Cmb_Country, txt_Alert);
            Validate_About_You(TA_AboutYou, txt_Alert);
            //System.out.println(FLAG);
            //If All Field Validated*/
            if(FLAG==true){
                //System.out.println("Flag true");
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "", new ButtonType("OK"));
                a.setTitle("Confirm Registration");
                a.setHeaderText("Succesfully registerd");
                // a.setContentText("Content text");
                a.showAndWait();}
            // else
            //System.out.println("Flag falseeeeeeee&");
        });
         
        TF_Name.setOnKeyReleased(e->{
            txt_Alert.setText("");
            Validate_Name(TF_Name, txt_Alert);});
        
        TF_Email.setOnKeyReleased(e->{
            txt_Alert.setText("");
            Validate_Email(TF_Email, txt_Alert);
        });
    
        TF_Phone.setOnKeyReleased(e->{
            txt_Alert.setText("");
            Validate_Phone_Number(TF_Phone, txt_Alert);
        });
    
        TF_Password.setOnKeyReleased(e->{
            txt_Alert.setText("");
            Validate_Strong_Password(TF_Password, txt_Alert);
            
        });
    
        TF_Confirm.setOnKeyReleased(e->{
            txt_Alert.setText("");
            Validate_Confirm_Password(TF_Confirm, TF_Password, txt_Alert);
        });
    
        TA_AboutYou.setOnKeyReleased(e->{
            txt_Alert.setText("");
            Validate_About_You(TA_AboutYou, txt_Alert);
            
        });
    
        form_Reg.addColumn(0, txt_Name,txt_Email,txt_Phone,txt_Password,txt_Confirm,txt_Country,txt_Gender,txt_Language,txt_About);
        form_Reg.addColumn(1, TF_Name,TF_Email,TF_Phone,TF_Password,TF_Confirm,Cmb_Country);
        form_Reg.add(HB_Rdb, 1, 6);
        form_Reg.add(HB_chkBx, 1, 7);
        form_Reg.add(TA_AboutYou, 1, 8);
        form_Reg.add(btn_Register, 1, 9, 2, 1);
        // btn_Already.setPrefWidth(scene_Reg.getWidth()/2);
        form_Reg.add(btn_Already, 0, 10,2, 1);
        btn_Already.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
        form_Reg.add(txt_Alert, 0, 10, 2, 1);
        
        return scene_Reg;
    }

    private Scene LoginFormScene() {
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
        loginForm.setBackground(BACKGROUND_Fill);   
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
        loginForm.add(btnLogin, 1, 4);
        
        btnReg.setStyle("-fx-background-color: linear-gradient(blue, #be1d00);-fx-font-size:18px;font-weight:bold;-fx-background-radius: 10; -fx-background-insets: 0;\n" +
                "-fx-text-fill: white;");
        btnReg.setPadding(new Insets(15));
        btnReg.setMaxWidth(100);
        loginForm.add(btnReg,2,4);
        
        
        // loginForm.getChildren().addAll(label,imgView,lblUserName,txttUserName,lblPassword,txttPassword);
        
        Scene sceneLogin;
        sceneLogin=new Scene(loginForm,900,700);
        
        

        return  sceneLogin;
        
    }
   
    public static void main(String[] args) {
        launch(args);
    }
    
}
