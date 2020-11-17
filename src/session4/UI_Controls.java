package session4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class UI_Controls extends Application {
     private static final Background BACKGROUND_Fill = new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(20),new Insets(10) ));
      private Button CreateButton_WithStyle() {
        Button btn=new Button("Pess Me :)");
        // btn.setPadding(new Insets(10));
        btn.setStyle("-fx-background-color:CORAL; "
                + "-fx-background-radius: 6, 5;\n" +
                "-fx-cursor: hand;"+
                "-fx-text-fill: #395306; "
                + "-fx-font-weight: bold;\n" +
                "-fx-font-size: 22px;"
                + "-fx-padding: 10 20 10 20;"
                + "-fx-font-family: \"Arial\"");
        return btn;
    }

    private Polygon CreatePolygon_WithStyle() {
        /*  double ArrayPolygon[]= new double[]
        {200.0,50.0,
        400.0,50.0,
        450.0,150.0,
        400.0,250.0,
        200.0,250,
        150.0,150
        };*/
        
        Polygon polygon=new Polygon();
        polygon.getPoints().addAll(new Double[]
        {200.0,50.0,
            400.0,50.0,
            450.0,150.0,
            400.0,250.0,
            200.0,250.0,
            150.0,150.0
        });
        polygon.setSmooth(true);
        polygon.setFill(Color.PINK);
        polygon.setStroke(Color.BLACK);
        polygon.setStrokeDashOffset(10.0);
        return polygon;
    }

    private Line DrawLine_WithStyle() {
        Line line=new Line();
        line.setStartX(100);
        line.setStartY(50);
        line.setEndX(200);
        line.setEndY(100);
        line.setStroke(Color.WHITE);
        line.setStrokeWidth(10);
        return line;
    }

    private Label CreateLabel_WithStyle() {
        Label label=new Label("Different Shapes");
        label.setStyle("-fx-font-size:24;"
                + "-fx-font-weight:bold;"
                + "-fx-font-family:\"Helvetica\"");
        label.setUnderline(true);
        return label;
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        Label label=CreateLabel_WithStyle();
        Line line=DrawLine_WithStyle();
        Polygon polygon=CreatePolygon_WithStyle();
        Button btn=CreateButton_WithStyle();
        
        GridPane grid=new GridPane();
      
        grid.setHgap(30);
        grid.setVgap(40);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50));
        grid.setBackground(BACKGROUND_Fill);        
        grid.add(label, 1, 0);
        grid.add(line, 0, 1);
        grid.add(polygon, 1,1);
        grid.add(new Label("\n \n\n\n"), 0, 2);
        grid.add(btn,1, 2);
        
      // grid.setGridLinesVisible(true);
        
        Scene scene1=new Scene(grid);
      
        /*OR I Can use Flow Pane 
            FlowPane flowpane=new FlowPane();
            flowpane.setAlignment(Pos.CENTER);
            flowpane.setOrientation(Orientation.VERTICAL);
            flowpane.setColumnHalignment(HPos.CENTER);
            flowpane.setVgap(20);
            flowpane.getChildren().addAll(line,polygon);
            Scene scene1=new Scene(flowpane);*/
        
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

   
   
    public static void main(String[] args) {
        launch(args);
    }
    
}
