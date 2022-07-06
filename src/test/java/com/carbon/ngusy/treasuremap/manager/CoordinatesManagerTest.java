package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.model.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordinatesManagerTest {

    @Test
    public void should_add_one_x_to_coordinate() {
        Coordinates coordinates = new Coordinates(1,2);

        Coordinates newCoordinates = CoordinatesManager.addOneX(coordinates);

        Assertions.assertEquals(2, newCoordinates.getX());
    }

    @Test
    public void should_add_one_y_to_coordinate() {
        Coordinates coordinates = new Coordinates(1,2);

        Coordinates newCoordinates = CoordinatesManager.addOneY(coordinates);

        Assertions.assertEquals(3, newCoordinates.getY());
    }

    @Test
    public void should_add_remove_x_to_coordinate() {
        Coordinates coordinates = new Coordinates(1,2);

        Coordinates newCoordinates = CoordinatesManager.removeOneX(coordinates);

        Assertions.assertEquals(0, newCoordinates.getX());
    }

    @Test
    public void should_add_remove_y_to_coordinate() {
        Coordinates coordinates = new Coordinates(1,2);

        Coordinates newCoordinates = CoordinatesManager.removeOneY(coordinates);

        Assertions.assertEquals(1, newCoordinates.getY());
    }

}