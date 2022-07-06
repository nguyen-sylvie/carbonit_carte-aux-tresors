package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.enumeration.ActionEnum;
import com.carbon.ngusy.treasuremap.model.Adventurer;

public class AdventurerTurnManager {

    /**
     * Get adventurer's current move
     * @param adventurer
     * @return char currentMove
     */
    public static char currentMove(Adventurer adventurer) {
        String sequenceMovements = adventurer.getMovements();

        char currentMove = adventurer.getMovements().charAt(0);
        adventurer.setMovements(sequenceMovements.substring(1));

        return currentMove;
    }

    /**
     * Check if the adventurer still has moves
     * @param adventurer
     * @return boolean hasMovesLeft
     */
    public static boolean hasMovesLeft(Adventurer adventurer) {
        return adventurer.getMovements().length() > 0;
    }

    /**
     * Handles adventurer's moves
     * @param adventurer
     */
    public static void play(Adventurer adventurer) {
            ActionEnum currentAction = ActionEnum.getBySymbol(String.valueOf(AdventurerTurnManager.currentMove(adventurer)));
            switch (currentAction) {
                case FORWARD:
                    AdventurerMovementManager.moveForward(adventurer);
                    break;
                case RIGHT:
                    AdventurerMovementManager.turnRight(adventurer);
                    break;
                case LEFT:
                    AdventurerMovementManager.turnLeft(adventurer);
                    break;
                default:
                    System.out.println("Error in " + adventurer.toString() + "'s turn");
                    break;
            }
    }
}
