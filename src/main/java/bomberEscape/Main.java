package bomberEscape;

import javafx.application.Application;
import javafx.stage.Stage;
import jade.*;
import java.io.File;
import java.util.Objects;

public class Main extends Application {

	public static void main(String[] args) {
            String[] params = new String[2];
            params[0] = "-gui";
            params[1] = "Player:bomberEscape.SMA.PlayerAgent";
            Boot.main(params);
            
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
