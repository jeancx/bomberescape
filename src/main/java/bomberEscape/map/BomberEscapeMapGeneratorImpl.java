package bomberEscape.map;

import bomberEscape.factory.BomberEscapeObjectFactory;
import bomberEscape.go.GameObject;

public class BomberEscapeMapGeneratorImpl extends MapGeneratorImpl<MapEntity> {

	private BomberEscapeObjectFactory	objectFactory;

	public BomberEscapeMapGeneratorImpl(BomberEscapeObjectFactory objectFactory) {
		super();
		this.objectFactory = objectFactory;
	}

	@Override
	protected GameObject generateEntity(int x, int y, MapEntity entity) {
		switch (entity) {
		case W:
			return objectFactory.getWall(x, y);
		case E:
			return objectFactory.getMovableObject(x, y);
		case P:
			return objectFactory.getPlayer(x, y);
		case B:
			return objectFactory.getBomb(x, y);
		case N:
		default:
			return null;
		}
	}

}
