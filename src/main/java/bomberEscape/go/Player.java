package bomberEscape.go;

import bomberEscape.GameEngine;
import bomberEscape.factory.GameObjectFactory;
import bomberEscape.keyboard.KeyListener;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.List;

import static bomberEscape.go.Direction.E;
import static bomberEscape.go.Direction.N;
import static bomberEscape.go.Direction.S;
import static bomberEscape.go.Direction.W;
import static javafx.scene.input.KeyCode.*;

public class Player extends MovableObject implements KeyListener {

	private KeyCode	currentlyPressed;

	public Player(double x, double y, double width, double height, Color color) {
		super(x, y, width, height, color);
		this.speed = 0;
	}

	@Override
	public List<KeyCode> interestedIn() {
		return Arrays.asList(LEFT, RIGHT, UP, DOWN);
	}

	@Override
	public void notify(KeyEvent keyEvent) {
		EventType<? extends Event> eventType = keyEvent.getEventType();
		if (KeyEvent.KEY_RELEASED.equals(eventType)) {
			if (keyEvent.getCode().equals(currentlyPressed)) {
				this.speed = 0;
			}
		} else if (KeyEvent.KEY_PRESSED.equals(eventType)) {
			currentlyPressed = keyEvent.getCode();
			this.direction = getDirection(keyEvent);
			this.speed = 1;

		}

	}

	private Direction getDirection(KeyEvent keyEvent) {
		switch (keyEvent.getCode()) {
		case LEFT:
			return E;
		case UP:
			return N;
		case DOWN:
			return S;
		case RIGHT:
		default:
			return W;
		}
	}

	@Override
	protected <T extends GameObjectFactory> void collide(GameEngine<T, ?> atomSmasher, RandomMovableObject go1) {
		if (!isDead) {
			speed = 0;
			isDead = true;
			FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), node);
			fadeTransition.setFromValue(node.getOpacity());
			fadeTransition.setToValue(0);
			fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					atomSmasher.removeObjects(Player.this);
				}
			});
			fadeTransition.play();
		}
	}

}
