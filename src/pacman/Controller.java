package pacman;

import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pacman.PacManModel.Direction;

public class Controller implements EventHandler<KeyEvent> {
	public PacManModel pacmanModel;
	public Ghost redGhost;
	public Board board;
	public Ghost[] ghosts = {redGhost};
	private Point2D desiredLocation;
	private PacManModel.Direction direction;
	public Controller() {
		this.pacmanModel = new PacManModel();
		this.board = new Board(Pacman.level);
	}
	
	@Override
	public void handle(KeyEvent keyEvent) {
		boolean keyRecognized = true;
		KeyCode code = keyEvent.getCode();
		direction = PacManModel.Direction.NONE;
		Point2D currentLocation = pacmanModel.getCurrentLocation();
		desiredLocation = currentLocation;
		
		Image img = pacmanModel.currentImage;
		if (code == KeyCode.LEFT) {
			//System.out.print("Left");
			direction = PacManModel.Direction.LEFT;
			desiredLocation = currentLocation.add(new Point2D(-0.01, 0));
		} else if (code == KeyCode.RIGHT) {
			//System.out.print("Right");
			direction = PacManModel.Direction.RIGHT;
			desiredLocation = currentLocation.add(new Point2D(1.0, 0));
		} else if (code == KeyCode.UP) {
			//System.out.print("Up");
			direction = PacManModel.Direction.UP;
			desiredLocation = currentLocation.add(new Point2D(0, -0.01));
		} else if (code == KeyCode.DOWN) {
			//System.out.print("Down");
			direction = PacManModel.Direction.DOWN;
			desiredLocation = currentLocation.add(new Point2D(0, 1.0));
		} else {
			keyRecognized = false;
		}
		
		if (keyRecognized) {
            keyEvent.consume();
            // check to see if desired location is occupied
            System.out.print("(" + (int)desiredLocation.getX() + ", " + (int)desiredLocation.getY() + ") ");
            if (board.map[(int) desiredLocation.getX()][(int) desiredLocation.getY()] == 'W') {
            	direction = Direction.NONE;
            	pacmanModel.setDirection(direction);
            } else {
            	pacmanModel.setDirection(direction);
            	//updatePacman();
            }
        }
	}
	
	public void updatePacman(double elapsedSeconds) {
		//pacmanModel.setDirection(direction);
        pacmanModel.move(elapsedSeconds);
        pacmanModel.setCurrentImage(pacmanModel.currentImage);
        board.drawPacman(pacmanModel);
        detectCollision();
	}
	
	private void detectCollision() {
		Point2D currentLocation = pacmanModel.getCurrentLocation();
		if (direction == Direction.LEFT) {
			desiredLocation = currentLocation.add(new Point2D(-0.01, 0));
		} else if (direction == Direction.RIGHT) {
			desiredLocation = currentLocation.add(new Point2D(1.0, 0));
		} else if (direction == Direction.UP) {
			desiredLocation = currentLocation.add(new Point2D(0, -0.01));
		} else if (direction == Direction.DOWN) {
			desiredLocation = currentLocation.add(new Point2D(0, 1.0));
		} else {
			desiredLocation = currentLocation;
		}
		if (board.map[(int) desiredLocation.getX()][(int) desiredLocation.getY()] == 'W') {
        	direction = Direction.NONE;
        	pacmanModel.setDirection(direction);
        }
        if (board.map[(int) desiredLocation.getX()][(int) desiredLocation.getY()] == 'P') {
        	for (Ghost g : ghosts) {
        		g.setState(true);
        	}
        }
	}
}
