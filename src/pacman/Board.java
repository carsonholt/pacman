package pacman;

import java.awt.Color;
import java.awt.Graphics;

public class Board {
	int width = 600;
	int height = 720;
	int gridSize = 24;
	
	int[][] map;
	
	public Board(int level) {
		map = new int[25][30];
	}
	
	public void drawBoard(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
	}
	
	public void paint(Graphics g) {
		drawBoard(g);
	}
}
