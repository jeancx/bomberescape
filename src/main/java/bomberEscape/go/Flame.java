package bomberEscape.go;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import bomberEscape.GameEngine;
import bomberEscape.factory.GameObjectFactory;

public class Flame extends MovableObject {
	private final Direction	direction;
	private final Position	position;
	private final int		length;
	private final int		size;
	private Rectangle		rectangle;
	private boolean			start	= false;

	public Flame(int x, int y, Direction direction, int length, int size) {
		super(x, y, size, size, Color.RED);
		this.position = new Position(x, y);
		this.direction = direction;
		this.length = length;
		this.size = size;

		Rectangle rectangle = new Rectangle(x, y, 0, 0);
		rectangle.setFill(Color.RED);

		node = rectangle;

	}

	public void play() {
		rectangle.setWidth(size);
		rectangle.setHeight(size);
		start = true;
	}


	@Override
	public void update(Scene scene, long time) {

	}

	@Override
	public <T extends GameObjectFactory> void collide(GameEngine<T, ?> atomSmasher, GameObject go1) {
	}
}
