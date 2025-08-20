package factory_method;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        // 1 = CityMap, 2 = WildernessMap
        game.main(2);
    }

}
