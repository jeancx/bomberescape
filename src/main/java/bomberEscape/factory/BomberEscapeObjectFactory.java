package bomberEscape.factory;

import bomberEscape.go.Bomb;
import bomberEscape.go.MovableObject;
import bomberEscape.go.Player;
import bomberEscape.go.Wall;

public interface BomberEscapeObjectFactory extends GameObjectFactory {

	MovableObject getMovableObject(int x, int y);

	Player getPlayer(int x, int y);

	Wall getWall(int x, int y);

	Bomb getBomb(int x, int y);

}
