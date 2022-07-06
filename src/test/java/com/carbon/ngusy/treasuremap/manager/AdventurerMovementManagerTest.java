package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.enumeration.OrientationEnum;
import com.carbon.ngusy.treasuremap.model.Adventurer;
import com.carbon.ngusy.treasuremap.model.Coordinates;
import com.carbon.ngusy.treasuremap.model.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AdventurerMovementManagerTest {

    @BeforeAll
    public static void mockMap() {
        Map.init(3, 3);
    }

    @Test
    public void should_move_up_adventurer_when_going_north() {
        Adventurer adventurer = new Adventurer("Leo", new Coordinates(1,1), OrientationEnum.NORTH, "AAGADAGG");

        AdventurerMovementManager.moveForwardNorth(adventurer);

        Assertions.assertEquals(1, adventurer.getPosition().getX());
        Assertions.assertEquals(0, adventurer.getPosition().getY());
    }

    @Test
    public void should_move_down_adventurer_when_going_south() {
        Adventurer adventurer = new Adventurer("Leo", new Coordinates(1,1), OrientationEnum.SOUTH, "AAGADAGG");

        AdventurerMovementManager.moveForwardSouth(adventurer);

        Assertions.assertEquals(1, adventurer.getPosition().getX());
        Assertions.assertEquals(2, adventurer.getPosition().getY());
    }

    @Test
    public void should_move_right_adventurer_when_going_east() {
        Adventurer adventurer = new Adventurer("Leo", new Coordinates(1,1), OrientationEnum.EAST, "AAGADAGG");

        AdventurerMovementManager.moveForwardEast(adventurer);

        Assertions.assertEquals(2, adventurer.getPosition().getX());
        Assertions.assertEquals(1, adventurer.getPosition().getY());
    }

    @Test
    public void should_move_left_adventurer_when_going_west() {
        Adventurer adventurer = new Adventurer("Leo", new Coordinates(1,1), OrientationEnum.WEST, "AAGADAGG");

        AdventurerMovementManager.moveForwardWest(adventurer);

        Assertions.assertEquals(0, adventurer.getPosition().getX());
        Assertions.assertEquals(1, adventurer.getPosition().getY());
    }

    @Test
    public void should_set_adventurer_orientation_to_south_when_turning_right_and_orientation_is_east() {
        Adventurer adventurer = new Adventurer("Leo", new Coordinates(1,2), OrientationEnum.EAST, "AAGADAGG");

        AdventurerMovementManager.turnRight(adventurer);

        Assertions.assertEquals(OrientationEnum.SOUTH, adventurer.getOrientation());
    }

    @Test
    public void should_set_adventurer_orientation_to_north_when_turning_left_and_orientation_is_east() {
        Adventurer adventurer = new Adventurer("Leo", new Coordinates(1,2), OrientationEnum.EAST, "AAGADAGG");

        AdventurerMovementManager.turnLeft(adventurer);

        Assertions.assertEquals(OrientationEnum.NORTH, adventurer.getOrientation());
    }
}