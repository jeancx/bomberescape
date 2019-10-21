package bomberEscape.go;

import bomberEscape.GameEngine;
import bomberEscape.factory.GameObjectFactory;
import javafx.animation.ScaleTransition;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Bomb extends GameObject {

	private static final long	BOMB_TIME	= 5000000000L;
	private long	startTime	= 0;
	private boolean	firstUpdate	= false;
	private ScaleTransition		ticking;

	public Bomb(int x, int y, int size) {
		super();
		Circle circle = new Circle();
		circle.setCenterX(x);
		circle.setCenterY(y);
		circle.setRadius(size);
		circle.setFill(Color.BLACK);

		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), node);
		scaleTransition.setFromX(1);
		scaleTransition.setFromY(1);
		scaleTransition.setToX(0.8);
		scaleTransition.setToY(0.8);
		scaleTransition.setAutoReverse(true);
		scaleTransition.setCycleCount(1000);

		node = circle;
		ticking = scaleTransition;
	}

	@Override
	public void update(Scene scene, long time) {
		if (!firstUpdate) {
			firstUpdate = true;
			startTime = time;
			ticking.play();
		}

		if (time - BOMB_TIME > startTime) {
			ticking.stop();
		}

	}

	@Override
	public <T extends GameObjectFactory> void collide(GameEngine<T, ?> atomSmasher, GameObject go1) {

	}

}
