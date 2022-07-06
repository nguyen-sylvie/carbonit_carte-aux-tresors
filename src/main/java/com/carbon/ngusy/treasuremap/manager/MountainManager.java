package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.model.Coordinates;
import com.carbon.ngusy.treasuremap.model.Map;
import com.carbon.ngusy.treasuremap.model.Mountain;

public class MountainManager {

    /**
     * Initializes mountain with data in parameter
     * @param data
     */
    public static void initializeMountain(String[] data) {
        int i = Integer.parseInt(data[1]);
        int j = Integer.parseInt(data[2]);

        Coordinates position = new Coordinates(i, j);

        Mountain mountain = new Mountain(position);
        Map.setTile(mountain);
    }
}
