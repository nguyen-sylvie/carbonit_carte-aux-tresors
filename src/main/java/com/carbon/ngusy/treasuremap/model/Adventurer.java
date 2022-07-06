package com.carbon.ngusy.treasuremap.model;

import com.carbon.ngusy.treasuremap.enumeration.OrientationEnum;

public class Adventurer extends Tile {
    private String name;
    private OrientationEnum orientation;
    private int nbTreasuresCollected;
    private String movements;

    public Adventurer(String name, Coordinates position, OrientationEnum orientation, String movements) {
        super(position);
        this.name = name;
        this.orientation = orientation;
        this.nbTreasuresCollected = 0;
        this.movements = movements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationEnum orientation) {
        this.orientation = orientation;
    }

    public int getTreasuresCollected() {
        return this.nbTreasuresCollected;
    }

    public void setTreasuresCollected(int treasuresCollected) {
        this.nbTreasuresCollected = treasuresCollected;
    }

    public String getMovements() {
        return movements;
    }

    public void setMovements(String movements) {
        this.movements = movements;
    }

    @Override
    public String display() {
        return "A";
    }

    @Override
    public String toString() {
        return "Adventurer{" +
                "name='" + name + '\'' +
                ", orientation=" + orientation +
                ", nbTreasuresCollected=" + nbTreasuresCollected +
                ", movements='" + movements + '\'' +
                '}';
    }
}
