package bomberEscape.map;

import bomberEscape.go.GameObject;

import java.util.List;

public interface MapGenerator<Entity> {
	List<GameObject> generate(List<List<Entity>> mapEntities);
}
