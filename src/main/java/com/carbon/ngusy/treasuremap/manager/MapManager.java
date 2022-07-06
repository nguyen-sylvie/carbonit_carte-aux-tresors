package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.constants.FileConstants;
import com.carbon.ngusy.treasuremap.enumeration.TileEnum;
import com.carbon.ngusy.treasuremap.model.Map;
import com.carbon.ngusy.treasuremap.model.*;

import java.util.Arrays;
import java.util.List;

public class MapManager {

    /**
     * Initializes map with data in parameter
     * @param data
     */
    public static void initializeMap(String[] data) {
        int width = Integer.parseInt(data[1]);
        int height = Integer.parseInt(data[2]);
        Map.init(width, height);
    }

    /**
     * Loads data and calls the adequate function for tile's initialization
     * @param inputDataList
     */
    public static void loadingData(List<String> inputDataList) {
        System.out.println("Data loading from input file\n");

        for (String inputDataLine: inputDataList) {
            String[] inputData = inputDataLine.split(FileConstants.LINE_SEPARATOR);

            TileEnum currentTile = TileEnum.getBySymbol(inputData[0]);

            switch (currentTile) {
                case MAP:
                    MapManager.initializeMap(inputData);
                    break;

                case MOUNTAIN:
                    MountainManager.initializeMountain(inputData);
                    break;

                case TREASURE:
                    TreasureManager.initializeTreasures(inputData);
                    break;

                case ADVENTURER:
                    AdventurerManager.initializeAdventurer(inputData);
                    break;

                default:
                    System.out.println("Error in data loading: can't identified the current tile");
                    break;
            }
        }
        System.out.println("Map initialized\n");
    }

    /**
     * Check if the position is in the map
     * @param position
     * @return boolean isValidPosition
     */
    public static boolean isValidPosition(Coordinates position) {
        return (position.getX() >= 0 && position.getX() < Map.getWidth() &&
            position.getY() >= 0 && position.getY() < Map.getHeight());
    }

    /**
     * Check if the tile is a treasure
     * @param position
     * @return boolean isTileTreasure
     */
    public static boolean isTileTreasure(Coordinates position) {
        Tile currentTile = Map.getTile(position);
        return currentTile instanceof Treasures;
    }

    /**
     * Check if the tile is a mountain
     * @param position
     * @return boolean isTileMountain
     */
    public static boolean isTileMountain(Coordinates position) {
        Tile currentTile = Map.getTile(position);
        return currentTile instanceof Mountain;
    }

    /**
     * Replaces the tile at the position given to a plain
     * @param position
     */
    public static void removeTile(Coordinates position) {
        Map.setTile(new Plain(position));
    }

    /**
     * Places the adventurers on the map
     * @return
     */
    public static Tile[][] getMapWithAdventurers() {
        Tile[][] mapWithAdventurers = Arrays.stream(Map.getMap()).map((Tile[] row) -> row.clone()).toArray((int length) -> new Tile[length][]);

        for(Adventurer adventurer : TurnManager.getAdventurers())
            mapWithAdventurers[adventurer.getPosition().getX()][adventurer.getPosition().getY()] = adventurer;

        return mapWithAdventurers;
    }

    /**
     * Moves an obstacle
     * @param oldPosition
     * @param newPosition
     */
    public static void moveObstacle(Coordinates oldPosition, Coordinates newPosition) {
        Map.getTile(oldPosition).setObstacle(false);
        Map.getTile(newPosition).setObstacle(true);
    }
}
