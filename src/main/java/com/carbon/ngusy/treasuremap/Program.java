package com.carbon.ngusy.treasuremap;

import com.carbon.ngusy.treasuremap.constants.FileConstants;
import com.carbon.ngusy.treasuremap.manager.DataFormattingManager;
import com.carbon.ngusy.treasuremap.manager.MapManager;
import com.carbon.ngusy.treasuremap.manager.TurnManager;
import com.carbon.ngusy.treasuremap.model.*;
import com.carbon.ngusy.treasuremap.utils.ReadFile;
import com.carbon.ngusy.treasuremap.utils.WriteFile;

import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<String> inputDataList = ReadFile.filetoStringList(FileConstants.PATH_IN, FileConstants.FILE_IN);

        MapManager.loadingData(inputDataList);

        Map.display();

        TurnManager.playAllAdventurers();

        Map.display();

        List<String> data = DataFormattingManager.mapToStringList();

        WriteFile.StringListToFile(FileConstants.PATH_OUT, FileConstants.FILE_OUT, data);
    }
}
