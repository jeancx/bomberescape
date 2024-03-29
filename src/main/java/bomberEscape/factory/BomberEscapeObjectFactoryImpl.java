package bomberEscape.factory;

import javafx.scene.paint.Color;
import bomberEscape.go.Bomb;
import bomberEscape.go.Player;
import bomberEscape.go.RandomMovableObject;
import bomberEscape.go.Wall;
import bomberEscape.keyboard.KeyLogger;

public class BomberEscapeObjectFactoryImpl implements BomberEscapeObjectFactory {

	private static final int	SIZE	= 30;

	private KeyLogger			keyLogger;

	public BomberEscapeObjectFactoryImpl(KeyLogger keyLogger) {
		super();
		this.keyLogger = keyLogger;
	}

	public Wall getWall(double x, double y, double width, double height, Color color) {
		return new Wall(x * SIZE, y * SIZE, width, height, color);
	}

	@Override
	public Wall getWall(int x, int y) {
		return new Wall(x * SIZE, y * SIZE, SIZE, SIZE, Color.GREY);
	}

	@Override
	public RandomMovableObject getMovableObject(int x, int y) {
		return new RandomMovableObject(x * SIZE + 1, y * SIZE + 1, SIZE - 2, SIZE - 2, Color.ORANGE);
	}

	@Override
	public Player getPlayer(int x, int y) {
		Player player = new Player(x * SIZE + 5, y * SIZE + 5, SIZE - 10, SIZE - 10, Color.GREEN);
		keyLogger.registerListener(player);
		return player;

	}

	@Override
	public Bomb getBomb(int x, int y) {
		return new Bomb(x * SIZE + SIZE / 2, y * SIZE + SIZE / 2, SIZE / 2 - 1);
	}

}
