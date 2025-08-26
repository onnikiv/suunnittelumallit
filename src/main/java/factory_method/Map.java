package factory_method;

public abstract class Map {

    public abstract Tile createTile();

    public void display() {

        int size = 64; // 1x1, 2x2 jne.

        for (int i = 1; i < (size + 1); i++) {
            System.out.print(this.createTile().getCharacter() + " ");

            if (i % Math.sqrt(size) == 0) {
                System.out.println();
            }
        }

    }
}
