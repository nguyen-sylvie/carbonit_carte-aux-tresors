package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.model.Coordinates;
import com.carbon.ngusy.treasuremap.model.Map;
import com.carbon.ngusy.treasuremap.model.Treasures;


public class TreasureManager {

    /**
     * Initializes mountain with data in parameter
     * @param data
     */
    public static void initializeTreasures(String[] data) {
        int i = Integer.parseInt(data[1]);
        int j = Integer.parseInt(data[2]);
        int nbTreasures = Integer.parseInt(data[3]);

        Coordinates position = new Coordinates(i, j);

        Treasures treasures = new Treasures(position, nbTreasures);
        Map.setTile(treasures);
    }

    /**
     * Decrement the number of treasures on the tile and remove the tile if there is no more treasure
     * @param treasures
     */
    public static void removeTreasure(Treasures treasures) {
        treasures.setNbTreasures(treasures.getNbTreasures() - 1);

        if(treasures.getNbTreasures() == 0)
            MapManager.removeTile(treasures.getPosition());

    }
}
