package factory_method.maps;

import factory_method.Map;
import factory_method.Tile;
import factory_method.tiles.ForestTile;
import factory_method.tiles.SwampTile;
import factory_method.tiles.WaterTile;

public class WildernessMap extends Map {

    @Override
    public Tile createTile() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0 -> {
                return new SwampTile();
            }

            case 1 -> {
                return new WaterTile();
            }

        }
        return new ForestTile();
    }

}
