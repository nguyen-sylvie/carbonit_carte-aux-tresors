package com.carbon.ngusy.treasuremap.model;


import com.carbon.ngusy.treasuremap.manager.MapManager;

public class Map {
    private static Tile[][] map;

    private Map() {
    }

    public static void  init(int width, int height) {
        map = new Tile[width][height];

        for (int j = 0 ; j < height ; j++)
            for (int i = 0 ; i < width ; i++)
                map[i][j] = new Plain(new Coordinates(i,j));
    }

    public static Tile[][] getMap() {
        return map;
    }

    public static int getWidth() {
        return map.length;
    }

    public static int getHeight() {
        return map[0].length;
    }

    public static Tile getTile(Coordinates position) {
        return map[position.getX()][position.getY()];
    }

    public static void setTile(Tile tile) {
        if(MapManager.isValidPosition(tile.getPosition()))
            map[tile.getPosition().getX()][tile.getPosition().getY()] = tile;
    }

    public static void display() {
        Tile[][] mapWithAdventurers = MapManager.getMapWithAdventurers();

        System.out.println("Map(" + getWidth() + "x" + getHeight() + ")");

        for (int j = 0; j < getHeight() ; j++) {
            for (int i = 0; i < getWidth() ; i++) {
                Tile currentTile = mapWithAdventurers[i][j];
                System.out.printf("%-6s", currentTile.display());
                System.out.print("   ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");
    }
}
