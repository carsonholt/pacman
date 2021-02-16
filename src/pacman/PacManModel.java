package pacman;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PacManModel {
	public enum Direction {
        UP, DOWN, LEFT, RIGHT, NONE
    };
    
	private Image pacLeft;
	private Image pacRight;
	private Image pacUp;
	private Image pacDown;
	private Image pacStill = new Image(getClass().getResource("/pac_still.png").toString());
	private Point2D location;
	private Direction direction;
	private Point2D velocity;
	private static final int PIXELS = 24;
	public static Image currentImage;
	private Canvas canvas;
	
	public PacManModel() {
		location = new Point2D(12, 23);
		direction = Direction.NONE;
		currentImage = pacStill;
		canvas = Pacman.canvas;
	}
	
	public void move(Direction dir) {
		//System.out.print(direction + " (" + location.getX() + ", " + location.getY() +")");
		location = location.add(changeLocation(dir));

	}
	
	public Point2D changeLocation(Direction direction){
		System.out.print(direction + " (" + location.getX() + ", " + location.getY() +")");
        if(direction == Direction.LEFT){
            return new Point2D(-1,0);
        }
        else if(direction == Direction.RIGHT){
            return new Point2D(1,0);
        }
        else if(direction == Direction.UP){
            return new Point2D(0,-1);
        }
        else if(direction == Direction.DOWN){
            return new Point2D(0,1);
        }
        else{
            return new Point2D(0,0);
        }
    }

	public void setCurrentDirection(Direction dir) {
		// TODO Auto-generated method stub
		this.direction = dir;
	}
	
	public void setCurrentLocation(Point2D loc) {
		this.location = loc;
	}
	
	public void setCurrentImage(Image img) {
		this.currentImage = img;
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(currentImage, this.location.getX() * PIXELS, this.location.getY() * PIXELS);	
	}
}
