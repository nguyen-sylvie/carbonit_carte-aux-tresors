package com.carbon.ngusy.treasuremap.enumeration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class OrientationEnumTest {

    @Test
    public void should_return_east_when_turning_right_and_orientation_is_north() {
        OrientationEnum orientation = OrientationEnum.NORTH;

        OrientationEnum newOrientation = orientation.right();

        Assertions.assertEquals(OrientationEnum.EAST, newOrientation);
    }

    @Test
    public void should_not_return_west_when_turning_right_and_orientation_is_north() {
        OrientationEnum orientation = OrientationEnum.NORTH;

        OrientationEnum newOrientation = orientation.right();

        Assertions.assertNotEquals(OrientationEnum.WEST, newOrientation);
    }

    @Test
    public void should_return_west_when_turning_left_and_orientation_is_north() {
        OrientationEnum orientation = OrientationEnum.NORTH;

        OrientationEnum newOrientation = orientation.left();

        Assertions.assertEquals(OrientationEnum.WEST, newOrientation);
    }

    @Test
    public void should_not_return_east_when_turning_left_and_orientation_is_north() {
        OrientationEnum orientation = OrientationEnum.NORTH;

        OrientationEnum newOrientation = orientation.left();

        Assertions.assertNotEquals(OrientationEnum.EAST, newOrientation);
    }
}