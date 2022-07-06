package com.carbon.ngusy.treasuremap.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    /**
     * Read an input file
     * @param path
     * @param fileName
     * @return
     */
    public static List<String> filetoStringList(String path, String fileName) {
        System.out.println("File reading " + path + fileName + "\n");
        List<String> inputData = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(path + fileName);
            Scanner scanner = new Scanner(fileInputStream);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                inputData.add(line);
            }

            scanner.close();

        } catch(IOException e) {
            System.out.println("Error in data loading: can't find " + path + fileName);
            System.exit(1);
        }

        return inputData;
    }
}
