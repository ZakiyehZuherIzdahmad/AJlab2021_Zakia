package forms;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ImageSlider extends Pane{
        private int imgNum = 0;
	private Timeline TimeLineanimation;

       
	ImageSlider() {
		getImage();
		TimeLineanimation = new Timeline(new KeyFrame(Duration.millis(2000), e ->{ nextImage(); }));
		TimeLineanimation.setCycleCount(Timeline.INDEFINITE);
		TimeLineanimation.play();}

	private void getImage() {
		getChildren().clear();
		getChildren().add( new ImageView("File:///E:\\Computer Science_University\\Sem6- October Fall 2020\\Advanced Java Lab\\AJlab2021\\src\\Images\\pic"+imgNum+".jpg"));
	}

        
	 void nextImage() {
		if (imgNum < 4) 
			imgNum++;
		else 
			imgNum = 0;
		getImage();
                
	}
}