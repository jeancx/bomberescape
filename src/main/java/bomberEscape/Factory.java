package bomberEscape;

import bomberEscape.factory.BomberEscapeObjectFactory;
import bomberEscape.factory.BomberEscapeObjectFactoryImpl;
import bomberEscape.factory.GameObjectFactory;
import bomberEscape.keyboard.KeyLogger;
import bomberEscape.keyboard.KeyLoggerImpl;
import bomberEscape.map.BomberEscapeMapGeneratorImpl;
import bomberEscape.map.BomberEscapeMapParserImpl;
import bomberEscape.map.MapGenerator;
import bomberEscape.map.MapParser;

public final class Factory {
	private static final Factory	FACTORY	= new Factory();

	private final KeyLogger			keyLogger;
	private final GameObjectFactory	factory;
	private final MapParser<?>		mapParser;
	private final MapGenerator<?>	generator;

	private Factory() {
		keyLogger = new KeyLoggerImpl();
		factory = new BomberEscapeObjectFactoryImpl(keyLogger);
		mapParser = new BomberEscapeMapParserImpl();
		generator = new BomberEscapeMapGeneratorImpl((BomberEscapeObjectFactory) factory);
	}

	public static KeyLogger getKeyLogger() {
		return FACTORY.keyLogger;
	}

	public static GameObjectFactory getFactory() {
		return FACTORY.factory;
	}

	public static MapGenerator<?> getGenerator() {
		return FACTORY.generator;
	}

	public static MapParser<?> getMapParser() {
		return FACTORY.mapParser;
	}
}
