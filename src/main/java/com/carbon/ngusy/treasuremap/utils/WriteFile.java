package com.carbon.ngusy.treasuremap.utils;

import java.io.*;
import java.util.List;

public class WriteFile {

    /**
     * Write an output file
     * @param path
     * @param fileName
     * @param data
     */
    public static void StringListToFile(String path, String fileName, List<String> data) {
        System.out.println("File writing " + path + fileName + "\n");
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + fileName), "utf-8"));
            for(String line : data) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error in writing output file " + path + fileName);
            System.exit(1);
        }
    }
}
