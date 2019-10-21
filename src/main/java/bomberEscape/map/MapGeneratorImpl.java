package bomberEscape.map;

import bomberEscape.go.GameObject;

import java.util.ArrayList;
import java.util.List;

public abstract class MapGeneratorImpl<Entity> implements MapGenerator<Entity> {

	@Override
	public List<GameObject> generate(List<List<Entity>> mapEntities) {
		List<GameObject> gameObjects = new ArrayList<>();
		for (int y = 0; y < mapEntities.size(); y++) {
			List<Entity> inner = mapEntities.get(y);
			for (int x = 0; x < inner.size(); x++) {
				GameObject generateEntity = generateEntity(x, y, inner.get(x));
				if (generateEntity != null) {
					gameObjects.add(generateEntity);
				}
			}
		}
		return gameObjects;
	}

	protected abstract GameObject generateEntity(int x, int y, Entity entity);

}
