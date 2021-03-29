package pacman;

import java.awt.Graphics;

import javax.swing.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Pacman extends Application {
	public static Canvas canvas;
	public static int level = 1;
	
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,600,720, Color.BLACK);
		canvas = new Canvas(600,720);
		primaryStage.setScene(scene);
		primaryStage.show();
		//Board b = new Board(level);
		Controller ctrl = new Controller();
		/*JFrame f = new JFrame();
		f.setSize(600, 720);
		f.setTitle("Pacman");
		f.setVisible(true);
		f.setResizable(false);*/
		root.getChildren().add(canvas);
		root.requestFocus();
		root.setOnKeyPressed(ctrl);
		//b.gameLoop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
