package flyweight;

import java.util.ArrayList;

import flyweight.factory_method.Map;
import flyweight.factory_method.Tile;

public class MapController {

    private static final int GRID_WIDTH = 8;
    private static final int GRID_HEIGHT = 8;
    private final ArrayList<Tile> tiles;

    public MapController(Map map) {
        this.tiles = map.createMap();
    }

    public int getGridWidth() {
        return GRID_WIDTH;
    }

    public int getGridHeight() {
        return GRID_HEIGHT;
    }

    public ArrayList<Tile> getTiles() {
        return this.tiles;
    }

}
