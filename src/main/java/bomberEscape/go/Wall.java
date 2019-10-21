package bomberEscape.go;

import bomberEscape.GameEngine;
import bomberEscape.factory.GameObjectFactory;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall extends GameObject {

	public Wall(double x, double y, double width, double height, Color color) {
		Rectangle rectangle = new Rectangle(x, y, width, height);
		rectangle.setFill(color);

		node = rectangle;
	}

	@Override
	public void update(Scene scene, long time) {
	}

	@Override
	public <T extends GameObjectFactory> void collide(GameEngine<T, ?> atomSmasher, GameObject go1) {

	}

}
