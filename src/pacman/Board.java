package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pacman.PacManModel.Direction;

public class Board {
	private static final int width = 600;
	private static final int height = 720;
	private static final int PIXELS = 24;
	
	private Image dot = new Image(getClass().getResource("/dot.png").toString());
	private Image pellet = new Image(getClass().getResource("/pellet.png").toString());
	private Image wall = new Image(getClass().getResource("/wall.png").toString());
	//private Image pacStill = new Image(getClass().getResource("/pac_still.png").toString());
	//private PacManModel pacmanModel = new PacManModel();
	//private Image pacmanImage = pacmanModel.currentImage;
	private Canvas canvas;
	private GraphicsContext gc;
	private int[][] map;
	
	public Board(int level) {
		map = new int[25][30];
		canvas = Pacman.canvas;
		gc = canvas.getGraphicsContext2D();
		readFile(level);
		//gc.drawImage(pacmanModel.getCurrentImage(), pacmanModel.getLocation().getX() * PIXELS, pacmanModel.getLocation().getY() * PIXELS);
	}
	
	public void clearBoard(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
	}
	
	private void readFile(int level) {
		int row = 0;
		int col = 0;
		
		try {
			BufferedReader r=new BufferedReader(new FileReader("lvl/level" + level + ".txt"));
			int ch;
			while((ch=r.read())!=-1){				
				if (ch == '\n') {
					col = 0;
					row++;
				} else {
					//map[col][row] = ch;
					drawSprite((char) ch, col, row);
					col++;
				}
			}
			r.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw(PacManModel pacmanModel) {
		//map[col][row] = ch;
		
		//char ch = 0;
		
		// read in file
		/*for (int x = 0; x < width/PIXELS; x++) {
			for (int y = 0; y < height/PIXELS; y++) {
				if (ch == 'W') {
					gc.drawImage(wall, x*PIXELS, y*PIXELS);
				} 
				if (ch == '.') {
					gc.drawImage(dot, x*PIXELS, y*PIXELS);
				}
			}
		}*/
		//repaint();
		gc.clearRect(pacmanModel.getOldLocation().getX() * PIXELS, pacmanModel.getOldLocation().getY() * PIXELS, PIXELS, PIXELS);
		//System.out.println("Pacman location: (" + pacmanModel.getLocation().getX() + ", " + pacmanModel.getLocation().getY());
		gc.drawImage(pacmanModel.currentImage, pacmanModel.getCurrentLocation().getX() * PIXELS, pacmanModel.getCurrentLocation().getY() * PIXELS);
	}

	private void repaint() {
		// TODO Auto-generated method stub
		
	}

	public void paint(Graphics g) {
		//super.paint(g);
		clearBoard(g);
		//draw(g);
	}
	
	private void drawSprite(char ch, int x, int y) {
		if (ch == 'W') {
			gc.drawImage(wall, x*PIXELS, y*PIXELS);
		} 
		if (ch == '.') {
			gc.drawImage(dot, x*PIXELS, y*PIXELS);
		}
		
	}
	
	public void gameLoop() {
		//while (true) {
		//}
		
	}
}
