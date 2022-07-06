package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.constants.FileConstants;
import com.carbon.ngusy.treasuremap.enumeration.TileEnum;
import com.carbon.ngusy.treasuremap.model.*;

import java.util.ArrayList;
import java.util.List;

public class DataFormattingManager {

    /**
     * Add separator to the data list and generate a string
     * @param dataList
     * @return String
     */
    public static String addSeparator(List<String> dataList) {
        StringBuilder dataStringBuilder = new StringBuilder(dataList.get(0));
        for(int i = 1 ; i < dataList.size() ; i++) {
            dataStringBuilder.append(FileConstants.LINE_SEPARATOR);
            dataStringBuilder.append(dataList.get(i));
        }
        return dataStringBuilder.toString();
    }

    /**
     * Formats data for the map
     * @return List<String>
     */
    public static List<String> mapToData() {
        List<String> data = new ArrayList<>();
        data.add(TileEnum.MAP.getSymbol());
        data.add(String.valueOf(Map.getWidth()));
        data.add(String.valueOf(Map.getHeight()));
        return data;
    }

    /**
     * Formats data for a mountain
     * @return List<String>
     */
    public static List<String> mountainToData(Mountain mountain) {
        List<String> data = new ArrayList<>();
        data.add(TileEnum.MOUNTAIN.getSymbol());
        data.add(String.valueOf(mountain.getPosition().getX()));
        data.add(String.valueOf(mountain.getPosition().getY()));
        return data;
    }

    /**
     * Formats data for a treasure
     * @return List<String>
     */
    public static List<String> treasuresToData(Treasures treasures) {
        List<String> data = new ArrayList<>();
        data.add(TileEnum.TREASURE.getSymbol());
        data.add(String.valueOf(treasures.getPosition().getX()));
        data.add(String.valueOf(treasures.getPosition().getY()));
        data.add(String.valueOf(treasures.getNbTreasures()));
        return data;
    }

    /**
     * Formats data for an adventurer
     * @return List<String>
     */
    public static List<String> adventurerToData(Adventurer adventurer) {
        List<String> data = new ArrayList<>();
        data.add(TileEnum.ADVENTURER.getSymbol());
        data.add(String.valueOf(adventurer.getName()));
        data.add(String.valueOf(adventurer.getPosition().getX()));
        data.add(String.valueOf(adventurer.getPosition().getY()));
        data.add(adventurer.getOrientation().getSymbol());;
        data.add(String.valueOf(adventurer.getTreasuresCollected()));
        return data;
    }

    /**
     * Formats data for the data loading into the map
     * @return List<String>
     */
    public static List<String> mapToStringList() {
        List<String> data = new ArrayList<>();

        String mapLine = DataFormattingManager.addSeparator(DataFormattingManager.mapToData());
        data.add(mapLine);

        for (int j = 0; j < Map.getHeight() ; j++) {
            for (int i = 0; i < Map.getWidth() ; i++) {
                Coordinates currentPosition = new Coordinates(i, j);
                Tile currentTile = Map.getTile(currentPosition);

                if(MapManager.isTileMountain(currentPosition))
                    data.add(DataFormattingManager.addSeparator(DataFormattingManager.mountainToData((Mountain) currentTile)));
                else if(MapManager.isTileTreasure(currentPosition))
                    data.add(DataFormattingManager.addSeparator(DataFormattingManager.treasuresToData((Treasures) currentTile)));
            }
        }

        for(Adventurer adventurer : TurnManager.getAdventurers())
            data.add(DataFormattingManager.addSeparator(DataFormattingManager.adventurerToData(adventurer)));

        return data;
    }
}
