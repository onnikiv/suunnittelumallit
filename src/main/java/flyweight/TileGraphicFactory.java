package flyweight;

import java.util.EnumMap;
import java.util.Map;

public class TileGraphicFactory {

    private static final Map<TileType, TileImage> images = new EnumMap<>(TileType.class);

    public static TileImage getTileImage(TileType type) {
        TileImage image = images.get(type);
        if (image == null) {
            switch (type) {
                case BUILDING ->
                    image = new TileImage("/building.png", "Building tile");
                case FOREST ->
                    image = new TileImage("/forest.png", "Forest tile");
                case ROAD ->
                    image = new TileImage("/road.png", "Road tile");
                case SWAMP ->
                    image = new TileImage("/swamp.png", "Swamp tile");
                case WATER ->
                    image = new TileImage("/water.png", "Water tile");
            }
            images.put(type, image);
        }
        return image;
    }
}
