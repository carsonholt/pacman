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
	private Point2D currentLocation;
	private Point2D oldLocation;
	private Direction direction;
	private Point2D velocity;
	private static final int PIXELS = 24;
	public Image currentImage;
	private Canvas canvas;
	public int lives;
	public int score;
	
	public PacManModel() {
		currentLocation = (new Point2D(12, 23));
		oldLocation = null;
		direction = Direction.NONE;
		currentImage = pacStill;
		canvas = Pacman.canvas;
		lives = 3;
		score = 0;
	}
	
	public void move(Direction dir) {
		// move pacman in the appropriate direction
		setOldLocation(currentLocation);
		currentLocation = getCurrentLocation().add(changeLocation(dir));
		setCurrentLocation(currentLocation);
		
		System.out.print(direction + " (" + currentLocation.getX() + ", " + currentLocation.getY() +")");

	}
	
	public Point2D changeLocation(Direction direction){
		//System.out.print(direction + " (" + getLocation().getX() + ", " + getLocation().getY() +")");
		
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

	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction dir) {
		// TODO Auto-generated method stub
		this.direction = dir;
	}
	
	public Image getCurrentImage() {
		return currentImage;
	}
	
	public void setCurrentImage(Image img) {
		this.currentImage = img;
		//GraphicsContext gc = canvas.getGraphicsContext2D();
		//gc.drawImage(currentImage, this.location.getX() * PIXELS, this.location.getY() * PIXELS);	
	}

	public Point2D getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Point2D location) {
		this.currentLocation = location;
	}
	
	public Point2D getOldLocation() {
		return oldLocation;
	}
	public void setOldLocation(Point2D loc) {
		this.oldLocation = loc;
	}
}
