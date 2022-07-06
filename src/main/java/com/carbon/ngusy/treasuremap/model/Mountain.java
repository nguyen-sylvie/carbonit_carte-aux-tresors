package com.carbon.ngusy.treasuremap.model;

public class Mountain extends Tile {

    public Mountain(Coordinates position) {
        super(position);
        super.setObstacle(true);
    }

    @Override
    public String display() {
        return "M";
    }

    @Override
    public String toString() {
        return "Mountain{}";
    }
}
