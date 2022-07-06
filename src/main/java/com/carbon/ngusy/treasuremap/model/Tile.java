package com.carbon.ngusy.treasuremap.model;

public abstract class Tile {
    private Coordinates position;
    private boolean isObstacle;

    protected Tile(Coordinates position) {
        this.position = position;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public void setObstacle(boolean obstacle) {
        isObstacle = obstacle;
    }

    public abstract String display();
}
