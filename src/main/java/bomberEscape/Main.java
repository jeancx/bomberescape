package bomberEscape;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BomberEscape atom = new BomberEscape();

		File map = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("map/map1.m")).getFile());

		atom.initialize(primaryStage, "BomberEscape", 800, 640, map);
		atom.beginGameLoop();
		primaryStage.show();
	}

}
