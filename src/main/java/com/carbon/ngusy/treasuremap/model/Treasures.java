package com.carbon.ngusy.treasuremap.model;

public class Treasures extends Tile {
    private int nbTreasures;

    public Treasures(Coordinates position, int nbTreasures) {
        super(position);
        super.setObstacle(false);
        this.nbTreasures = nbTreasures;
    }

    public int getNbTreasures() {
        return nbTreasures;
    }

    public void setNbTreasures(int nbTreasures) {
        this.nbTreasures = nbTreasures;
    }

    @Override
    public String display() {
        return "T(" + this.getNbTreasures() + ")";
    }
}
