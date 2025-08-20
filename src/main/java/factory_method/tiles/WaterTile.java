package factory_method.tiles;

import factory_method.Tile;

public class WaterTile implements Tile {

    @Override
    public char getCharacter() {
        return getType().charAt(0);
    }

    @Override
    public String getType() {
        return "Water";
    }

}
