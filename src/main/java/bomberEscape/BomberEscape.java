package bomberEscape;

import bomberEscape.factory.BomberEscapeObjectFactory;
import bomberEscape.map.MapEntity;
import bomberEscape.map.MapGenerator;
import bomberEscape.map.MapParser;

public class BomberEscape extends GameEngine<BomberEscapeObjectFactory, MapEntity> {

	public BomberEscape() {
		super((BomberEscapeObjectFactory) Factory.getFactory(), (MapParser<MapEntity>) Factory.getMapParser(), (MapGenerator<MapEntity>) Factory.getGenerator(),
				Factory.getKeyLogger());
	}


}
