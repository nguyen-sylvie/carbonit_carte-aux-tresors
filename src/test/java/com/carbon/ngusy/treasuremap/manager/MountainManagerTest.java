package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MountainManagerTest {

    @BeforeAll
    public static void mockMap() {
        Map.init(3, 3);
    }

    @Test
    void should_place_mountain_on_map() {
        String[] data = {"M","1","1"};

        MountainManager.initializeMountain(data);

        Tile tile = Map.getTile(new Coordinates(1,1));

        Assertions.assertTrue(tile instanceof Mountain);
    }

    @Test
    public void should_set_tile_as_obstacle_when_mountain_is_initialized() {
        String[] data = {"M","1", "1"};

        MountainManager.initializeMountain(data);

        Assertions.assertEquals(true, Map.getTile(new Coordinates(1,1)).isObstacle());
    }
}