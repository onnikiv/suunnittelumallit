package flyweight;

import flyweight.factory_method.Tile;
import flyweight.factory_method.maps.WildernessMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MapView extends Application {

    private static final int TILE_SIZE = 80;
    private final MapController controller = new MapController(new WildernessMap()); // Map type, CityMap or WildernessMap
    private final int CANVAS_WIDTH = controller.getGridWidth() * TILE_SIZE;
    private final int CANVAS_HEIGHT = controller.getGridHeight() * TILE_SIZE;
    private final Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
    private final GraphicsContext gc = canvas.getGraphicsContext2D();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flyweight Map Demo");

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        drawTiles();
    }

    private void drawTiles() {
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        int gridSize = (int) Math.sqrt(controller.getTiles().size());
        for (int i = 0; i < controller.getTiles().size(); i++) {
            Tile tile = controller.getTiles().get(i);
            int x = (i % gridSize) * TILE_SIZE;
            int y = (i / gridSize) * TILE_SIZE;

            TileType tileType = getTileTypeFromTile(tile);
            TileImage tileImage = TileGraphicFactory.getTileImage(tileType);
            Image image = tileImage.getImage();

            gc.drawImage(image, x, y, TILE_SIZE, TILE_SIZE);
        }
    }

    private TileType getTileTypeFromTile(Tile tile) {
        String type = tile.getType().toLowerCase();
        return switch (type) {
            case "building" ->
                TileType.BUILDING;
            case "forest" ->
                TileType.FOREST;
            case "road" ->
                TileType.ROAD;
            case "swamp" ->
                TileType.SWAMP;
            case "water" ->
                TileType.WATER;
            default ->
                null;
        };
    }
}
