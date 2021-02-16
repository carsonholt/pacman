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

public class Board {
	private static final int width = 600;
	private static final int height = 720;
	private static final int PIXELS = 24;
	
	private Image dot = new Image(getClass().getResource("/dot.png").toString());
	private Image pellet = new Image(getClass().getResource("/pellet.png").toString());
	private Image wall = new Image(getClass().getResource("/wall.png").toString());
	private Canvas canvas;
	private int[][] map;
	
	public Board(int level) {
		map = new int[25][30];
		canvas = Pacman.canvas;
		readFile(level);
	}
	
	public void drawBoard(Graphics g) {
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
					draw(ch, col, row);
					col++;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void draw(int ch, int col, int row) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		//map[col][row] = ch;
		
		if (ch == 'W') {
			gc.drawImage(wall, col*PIXELS, row*PIXELS);
		} 
		if (ch == '.') {
			gc.drawImage(dot, col*PIXELS, row*PIXELS);
		}
		
		/*
		switch (ch) {
		case 'W':
			gc.drawImage(wall, col*PIXELS, row*PIXELS);
		case '.':
			gc.drawImage(dot, col*PIXELS, row*PIXELS);
		case 'P':
			//gc.drawImage(pellet, col*PIXELS, row*PIXELS);
		}*/
	}
	
	public void paint(Graphics g) {
		drawBoard(g);
	}
}
