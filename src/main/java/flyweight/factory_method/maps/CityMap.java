package flyweight.factory_method.maps;

import flyweight.factory_method.Map;
import flyweight.factory_method.Tile;
import flyweight.factory_method.tiles.BuildingTile;
import flyweight.factory_method.tiles.ForestTile;
import flyweight.factory_method.tiles.RoadTile;

public class CityMap extends Map {

    @Override
    public Tile createTile() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0 -> {
                return new BuildingTile();
            }

            case 1 -> {
                return new RoadTile();
            }

        }
        return new ForestTile();
    }
}
