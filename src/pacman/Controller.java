package pacman;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller implements EventHandler<KeyEvent> {
	private PacManModel pacmanModel;
	
	public Controller() {
		this.pacmanModel = new PacManModel();
	}
	
	@Override
	public void handle(KeyEvent keyEvent) {
		boolean keyRecognized = true;
		KeyCode code = keyEvent.getCode();
		PacManModel.Direction direction = PacManModel.Direction.NONE;
		Image img = PacManModel.currentImage;
		if (code == KeyCode.LEFT) {
			//System.out.print("Left");
			direction = PacManModel.Direction.LEFT;
		} else if (code == KeyCode.RIGHT) {
			//System.out.print("Right");
			direction = PacManModel.Direction.RIGHT;
		} else if (code == KeyCode.UP) {
			//System.out.print("Up");
			direction = PacManModel.Direction.UP;
		} else if (code == KeyCode.DOWN) {
			//System.out.print("Down");
			direction = PacManModel.Direction.DOWN;
		} else {
			keyRecognized = false;
		}
		
		if (keyRecognized) {
            keyEvent.consume();
            pacmanModel.setCurrentDirection(direction);
            pacmanModel.move(direction);
            pacmanModel.setCurrentImage(img);
        }
		
	}
	
}
