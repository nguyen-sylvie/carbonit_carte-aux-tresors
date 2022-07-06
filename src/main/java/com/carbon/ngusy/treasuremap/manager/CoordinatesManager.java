package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.model.Coordinates;

public class CoordinatesManager {

    /**
     * Increments the x-axis
     * @param coordinates
     * @return new coordinates
     */
    public static Coordinates addOneX(Coordinates coordinates) {
        return new Coordinates(coordinates.getX()+1, coordinates.getY());
    }

    /**
     * Decrements the x-axis
     * @param coordinates
     * @return new coordinates
     */
    public static Coordinates removeOneX(Coordinates coordinates) {
        return new Coordinates(coordinates.getX()-1, coordinates.getY());
    }

    /**
     * Increments the y-axis
     * @param coordinates
     * @return new coordinates
     */
    public static Coordinates addOneY(Coordinates coordinates) {
        return new Coordinates(coordinates.getX(), coordinates.getY() + 1);
    }

    /**
     * Decrements the y-axis
     * @param coordinates
     * @return new coordinates
     */
    public static Coordinates removeOneY(Coordinates coordinates) {
        return new Coordinates(coordinates.getX(), coordinates.getY() - 1);
    }
}
