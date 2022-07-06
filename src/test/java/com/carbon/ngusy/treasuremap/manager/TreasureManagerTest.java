package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TreasureManagerTest {

    @BeforeAll
    public static void mockMap() {
        Map.init(3, 3);
    }

    @Test
    void should_place_treasures_on_map() {
        String[] data = {"T","1","1","2"};

        TreasureManager.initializeTreasures(data);

        Tile tile = Map.getTile(new Coordinates(1,1));

        Assertions.assertTrue(tile instanceof Treasures);
    }

    @Test
    public void should_decrement_number_of_treasures() {
        Treasures treasures = new Treasures(new Coordinates(1,1),2);

        TreasureManager.removeTreasure(treasures);

        Assertions.assertEquals(1, treasures.getNbTreasures());
    }

    @Test
    public void should_remove_treasures_when_nbTreasures_is_zero() {
        Treasures treasures = new Treasures(new Coordinates(1,1),1);

        TreasureManager.removeTreasure(treasures);

        boolean isTileTreasure = MapManager.isTileTreasure(new Coordinates(1,1));

        Assertions.assertTrue(!isTileTreasure);
    }
}