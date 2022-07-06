package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.enumeration.OrientationEnum;
import com.carbon.ngusy.treasuremap.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AdventurerManagerTest {

    @BeforeAll
    public static void mockMap() {
        Map.init(3, 3);
    }

    @Test
    public void should_set_tile_as_obstacle_when_adventurer_is_initialized() {
        String[] data = {"A","Leo","1", "2","N","AAGADAGG"};

        AdventurerManager.initializeAdventurer(data);

        Assertions.assertEquals(true, Map.getTile(new Coordinates(1,2)).isObstacle());
    }

    @Test
    public void should_not_increment_number_of_treasures_collected_when_adventurer_is_not_on_treasure() {
        Adventurer adventurer = new Adventurer("Leo", new Coordinates(1,2), OrientationEnum.NORTH, "AAGADAGG");
        Treasures treasures = new Treasures(new Coordinates(0,1), 1);
        Map.setTile(treasures);

        AdventurerManager.collectTreasure(adventurer);

        Assertions.assertEquals(0, adventurer.getTreasuresCollected());
    }

    @Test
    public void should_increment_number_of_treasures_collected_when_adventurer_is_on_treasure() {
        Adventurer adventurer = new Adventurer("Leo", new Coordinates(1,2), OrientationEnum.NORTH, "AAGADAGG");
        Treasures treasures = new Treasures(new Coordinates(1,2), 1);
        Map.setTile(treasures);

        AdventurerManager.collectTreasure(adventurer);

        Assertions.assertEquals(1, adventurer.getTreasuresCollected());
    }

}