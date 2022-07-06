package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.enumeration.OrientationEnum;
import com.carbon.ngusy.treasuremap.model.Adventurer;
import com.carbon.ngusy.treasuremap.model.Coordinates;
import com.carbon.ngusy.treasuremap.model.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AdventurerTurnManagerTest {
    @BeforeAll
    public static void mockMap() {
        Map.init(3, 3);
    }

    @Test
    public void should_return_current_move_adventurer() {
        Adventurer adventurer = new Adventurer("Leo", new Coordinates(1,2), OrientationEnum.NORTH, "AAGADAGG");

        char currentMove = AdventurerTurnManager.currentMove(adventurer);

        Assertions.assertEquals('A', currentMove);
    }

    @Test
    public void should_return_true_when_adventurer_still_has_moves() {
        Adventurer adventurer = new Adventurer("Leo", new Coordinates(1,2), OrientationEnum.NORTH, "AAGADAGG");

        boolean hasMovesLeft = AdventurerTurnManager.hasMovesLeft(adventurer);

        Assertions.assertEquals(true, hasMovesLeft);
    }

    @Test
    public void should_return_false_when_adventurer_does_not_have_moves() {
        Adventurer adventurer = new Adventurer("Leo", new Coordinates(1,2), OrientationEnum.NORTH, "");

        boolean hasMovesLeft = AdventurerTurnManager.hasMovesLeft(adventurer);

        Assertions.assertEquals(false, hasMovesLeft);
    }
}