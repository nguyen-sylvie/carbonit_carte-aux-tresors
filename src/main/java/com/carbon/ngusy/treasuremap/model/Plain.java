package com.carbon.ngusy.treasuremap.model;

public class Plain extends Tile {
    public Plain(Coordinates position) {
        super(position);
        super.setObstacle(false);
    }

    @Override
    public String display() {
        return ".";
    }

    @Override
    public String toString() {
        return "Plain{}";
    }
}
