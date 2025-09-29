package flyweight.factory_method;

import flyweight.factory_method.maps.CityMap;
import flyweight.factory_method.maps.WildernessMap;

public class Game {

    public void main(int mapType) {
        Map map;
        if (mapType == 1) {
            map = new CityMap();
        } else {
            map = new WildernessMap();
        }

        createMap(map);

    }

    public void createMap(Map map) {
        map.display();
    }
}
