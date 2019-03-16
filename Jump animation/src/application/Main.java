package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Animation");
			Group root = new Group();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			Canvas canvas = new Canvas(512,512);
			root.getChildren().add(canvas);
			
			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			Image green = new Image("green.png");
			
			Image[] arrayImages = new Image[36];
			for(int i=0;i<36;i++)
			{
				arrayImages[i] = new Image("rj_"+i+".png");
			}
			AnimatedImage man = new AnimatedImage();
			man.frames = arrayImages;
			man.duration = 0.1;
			
			final long startTime = System.nanoTime();
			
			new AnimationTimer() 
			{
				@Override
				public void handle(long now) {
					double dd = (now-startTime)/1000000000.0;
					
					gc.drawImage(green, 0, 0);
					gc.drawImage(man.geFrame(dd), 100, 100);
					
				}
				
			}.start();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
