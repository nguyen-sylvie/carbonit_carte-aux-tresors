package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.model.Coordinates;
import com.carbon.ngusy.treasuremap.model.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MapManagerTest {

    @BeforeAll
    public static void mockMap() {
        Map.init(3, 3);
    }

    @Test
    public void should_return_true_when_position_inside_map() {
        Coordinates position = new Coordinates(1,1);

        boolean isValidPosition = MapManager.isValidPosition(position);

        Assertions.assertTrue(isValidPosition);

    }

    @Test
    public void should_return_false_when_position_outside_map() {
        Coordinates position = new Coordinates(10,10);

        boolean isValidPosition = MapManager.isValidPosition(position);

        Assertions.assertEquals(false, isValidPosition);

    }

    @Test
    void should_return_true_if_tile_is_treasure() {
        String[] data = {"T","1","1","2"};

        TreasureManager.initializeTreasures(data);

        boolean isTileTreasure = MapManager.isTileTreasure(new Coordinates(1,1));

        Assertions.assertTrue(isTileTreasure);
    }

    @Test
    void should_return_true_if_tile_is_mountain() {
        String[] data = {"M","1","1"};

        MountainManager.initializeMountain(data);

        boolean isTileMountain = MapManager.isTileMountain(new Coordinates(1,1));

        Assertions.assertTrue(isTileMountain);
    }

}