package bomberEscape.go;

import bomberEscape.GameEngine;
import bomberEscape.factory.GameObjectFactory;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class MovableObject extends GameObject {

	public Position	last;
	public Position	position;
	public Direction	direction	= Direction.N;
	public int		speed		= 1;

	public MovableObject(double x, double y, double width, double height, Color color) {
		position = new Position((int) x, (int) y);

		Rectangle rectangle = new Rectangle(x, y, width, height);
		rectangle.setFill(color);

		node = rectangle;

	}

	@Override
	public void update(Scene scene, long time) {
		if (isDead) {
			return;
		}
		this.last = this.position;
		this.position = move(position, direction);
	}

	@Override
	public <T extends GameObjectFactory> void collide(GameEngine<T, ?> atomSmasher, GameObject go1) {
		if (go1 instanceof Wall) {
			collide(atomSmasher, (Wall) go1);
		} else if (go1 instanceof RandomMovableObject) {
			collide(atomSmasher, (RandomMovableObject) go1);
		} else if (go1 instanceof Bomb) {
			collide(atomSmasher, (Bomb) go1);
		}
	}

	protected <T extends GameObjectFactory> void collide(GameEngine<T, ?> atomSmasher, Wall go1) {
		if (last != null) {
			this.position = last;
		}
		last = null;
		moveToPosition(position);
	}

	protected <T extends GameObjectFactory> void collide(GameEngine<T, ?> atomSmasher, Bomb go1) {
		if (last != null) {
			this.position = last;
		}
		last = null;
		moveToPosition(position);
	}

	protected <T extends GameObjectFactory> void collide(GameEngine<T, ?> atomSmasher, RandomMovableObject go1) {
	}

	protected Position move(Position position, Direction direction) {
		Position newPosition;
		switch (direction) {
		case N:
			newPosition = position.north(speed);
			break;
		case E:
			newPosition = position.east(speed);
			break;
		case S:
			newPosition = position.south(speed);
			break;
		case W:
		default:
			newPosition = position.west(speed);
			break;
		}

		moveToPosition(newPosition);

		return newPosition;
	}

	protected void moveToPosition(Position newPosition) {
		this.node.setTranslateX(newPosition.getX());
		this.node.setTranslateY(newPosition.getY());
	}

}
