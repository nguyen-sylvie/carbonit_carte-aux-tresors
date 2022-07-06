package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.enumeration.OrientationEnum;
import com.carbon.ngusy.treasuremap.model.Adventurer;
import com.carbon.ngusy.treasuremap.model.Coordinates;
import com.carbon.ngusy.treasuremap.model.Map;
import com.carbon.ngusy.treasuremap.model.Treasures;

public class AdventurerManager {

    /**
     * Initialize an adventurer
     * @param data
     */
    public static void initializeAdventurer(String[] data) {
        int i = Integer.parseInt(data[2]);
        int j = Integer.parseInt(data[3]);
        String name = data[1];
        OrientationEnum orientation = OrientationEnum.getBySymbol(data[4]);
        String movements = data[5];

        Coordinates position = new Coordinates(i, j);

        if(MapManager.isValidPosition(position)) {
            Adventurer adventurer = new Adventurer(name, position, orientation, movements);
            TurnManager.addAdventurer(adventurer);

            Map.getTile(position).setObstacle(true);
        }
    }

    /**
     * Increment the number of treasures collected by the adventurer
     * And call the function which will decrement the number of treasures on the tile and remove the tile if there is no more treasure
     * @param adventurer
     */
    public static void collectTreasure(Adventurer adventurer) {
        Coordinates adventurerPosition = adventurer.getPosition();
        if(MapManager.isTileTreasure(adventurerPosition)) {
            Treasures treasures = (Treasures) Map.getTile(adventurerPosition);
            TreasureManager.removeTreasure(treasures);
            adventurer.setTreasuresCollected(adventurer.getTreasuresCollected() + 1);
        }
    }
}
