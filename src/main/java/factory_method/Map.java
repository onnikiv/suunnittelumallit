package factory_method;

public abstract class Map {

    public abstract Tile createTile();

    public void display() {
        for (int i = 1; i < 17; i++) {
            System.out.print(this.createTile().getCharacter() + " ");

            if (i % 4 == 0) {
                System.out.println();
            }
        }

    }
}
