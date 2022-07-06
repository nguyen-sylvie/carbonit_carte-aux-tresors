package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.model.Coordinates;
import com.carbon.ngusy.treasuremap.model.Map;
import com.carbon.ngusy.treasuremap.model.Adventurer;

public class AdventurerMovementManager {

    /**
     * Handles the movement according to the adventurer's orientation
     * @param adventurer
     */
    public static void moveForward(Adventurer adventurer) {
        Coordinates oldPosition = adventurer.getPosition();

        switch (adventurer.getOrientation()) {
            case NORTH:
                AdventurerMovementManager.moveForwardNorth(adventurer);
                break;
            case EAST:
                AdventurerMovementManager.moveForwardEast(adventurer);
                break;
            case SOUTH:
                AdventurerMovementManager.moveForwardSouth(adventurer);
                break;
            case WEST:
                AdventurerMovementManager.moveForwardWest(adventurer);
                break;
            default:
                System.out.println("Error in " + adventurer.toString() + " orientation");
        }

        MapManager.moveObstacle(oldPosition, adventurer.getPosition());
    }

    /**
     * Moves the adventurer to the north
     * @param adventurer
     */
    public static void moveForwardNorth(Adventurer adventurer) {
        Coordinates positionNorth = CoordinatesManager.removeOneY(adventurer.getPosition());
        if(MapManager.isValidPosition(positionNorth) && !Map.getTile(positionNorth).isObstacle()) {
            adventurer.setPosition(positionNorth);
            AdventurerManager.collectTreasure(adventurer);
        }
    }

    /**
     * Moves the adventurer to the east
     * @param adventurer
     */
    public static void moveForwardEast(Adventurer adventurer) {
        Coordinates positionEast = CoordinatesManager.addOneX(adventurer.getPosition());
        if(MapManager.isValidPosition(positionEast) && !Map.getTile(positionEast).isObstacle()) {
            adventurer.setPosition(positionEast);
            AdventurerManager.collectTreasure(adventurer);
        }
    }

    /**
     * Moves the adventurer to the south
     * @param adventurer
     */
    public static void moveForwardSouth(Adventurer adventurer) {
        Coordinates positionSouth = CoordinatesManager.addOneY(adventurer.getPosition());
        if(MapManager.isValidPosition(positionSouth) && !Map.getTile(positionSouth).isObstacle()) {
            adventurer.setPosition(positionSouth);
            AdventurerManager.collectTreasure(adventurer);
        }
    }

    /**
     * Moves the adventurer to the West
     * @param adventurer
     */
    public static void moveForwardWest(Adventurer adventurer) {
        Coordinates positionWest = CoordinatesManager.removeOneX(adventurer.getPosition());
        if(MapManager.isValidPosition(positionWest) && !Map.getTile(positionWest).isObstacle()) {
            adventurer.setPosition(positionWest);
            AdventurerManager.collectTreasure(adventurer);
        }
    }

    /**
     * Change the adventurer's orientation to the right
     * @param adventurer
     */
    public static void turnRight(Adventurer adventurer) {
        adventurer.setOrientation(adventurer.getOrientation().right());
    }

    /**
     * Change the adventurer's orientation to the left
     * @param adventurer
     */
    public static void turnLeft(Adventurer adventurer) {
        adventurer.setOrientation(adventurer.getOrientation().left());
    }

}
