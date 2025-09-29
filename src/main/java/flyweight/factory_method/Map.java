package flyweight.factory_method;

import java.util.ArrayList;

public abstract class Map {

    public abstract Tile createTile();

    public ArrayList<Tile> createMap() {
        int size = 64; // 1x1, 2x2 jne.
        ArrayList<Tile> tiles = new ArrayList<>();

        for (int i = 1; i < (size + 1); i++) {
            Tile tile = this.createTile();
            tiles.add(tile);
            System.out.print(tile.getCharacter() + " ");

            if (i % Math.sqrt(size) == 0) {
                System.out.println();
            }
        }

        return tiles;
    }
}
