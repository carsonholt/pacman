package pacman;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import pacman.PacManModel.Direction;

public class Ghost {
	private enum Color {
		RED, PINK, CYAN, ORANGE
	};
	
	private Color color;
	private Image ghostRed = new Image(getClass().getResource("/ghost_red.png").toString());;
	private Image ghostPink;
	private Image ghostCyan;
	private Image ghostOrange;
	private Image ghostBlue = new Image(getClass().getResource("/ghost_ill.png").toString());
	private Point2D currentLocation;
	private Point2D oldLocation;
	private Direction direction;
	public Image currentImage;
	public boolean state; // false for normal, true for edible state
	
	public Ghost(Color c) {
		setCurrentLocation(new Point2D(12, 15));
		setOldLocation(null);
		setDirection(Direction.NONE);
		state = false;
		color = c;
		currentImage = ghostRed;
	}
	
	public Point2D getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Point2D currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Point2D getOldLocation() {
		return oldLocation;
	}

	public void setOldLocation(Point2D oldLocation) {
		this.oldLocation = oldLocation;
	}

	public Point2D changeLocation() {
		//System.out.print(direction + " (" + getLocation().getX() + ", " + getLocation().getY() +")");
		//long elapsedTime = System.currentTimeMillis() - startTime;
		//System.out.println("Elapsed time: " + elapsedTime);
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

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean getState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public void move() {
		setOldLocation(currentLocation);
		currentLocation = getCurrentLocation().add(changeLocation());
		setCurrentLocation(currentLocation);
	}
}
