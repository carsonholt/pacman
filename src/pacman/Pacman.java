package pacman;

import java.awt.Graphics;

import javax.swing.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Pacman extends Application {
	public static Canvas canvas;
	public static int level = 1;
	public Controller ctrl;
	private static long NANO = 1000000000;
	
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,600,720, Color.BLACK);
		canvas = new Canvas(600,720);
		primaryStage.setScene(scene);
		primaryStage.show();
		//Board b = new Board(level);
		ctrl = new Controller();
		/*JFrame f = new JFrame();
		f.setSize(600, 720);
		f.setTitle("Pacman");
		f.setVisible(true);
		f.setResizable(false);*/
		
		root.getChildren().add(canvas);
		root.requestFocus();
		root.setOnKeyPressed(ctrl);
		
		/*AnimationTimer timer = */new AnimationTimer() {
			private long lastUpdate;
			
			@Override
			public void start() {
				lastUpdate = System.nanoTime();
				super.start();
			}
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				long elapsedNanoSeconds = now - lastUpdate;
				
				//convert from ns to s
				double elapsedSeconds = elapsedNanoSeconds / 1000000000.0;
				
				//System.out.println(elapsedSeconds);
				ctrl.updatePacman(elapsedSeconds);
				
				lastUpdate = now;
			}
			
		}.start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void update() {

	}
}
