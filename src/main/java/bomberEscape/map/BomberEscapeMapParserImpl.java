package bomberEscape.map;

public class BomberEscapeMapParserImpl extends MapParserImpl<MapEntity> {

	@Override
	protected MapEntity parseEntity(char charAt) {
		return MapEntity.valueOf(String.valueOf(charAt));
	}

}
