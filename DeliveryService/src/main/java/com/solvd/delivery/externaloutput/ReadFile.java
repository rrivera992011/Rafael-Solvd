package com.solvd.delivery.externaloutput;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);
    public static void readAFile(File file) throws IOException {

        LOGGER.log(MENU_LOG, "File has been read");

        String stringFromFile = FileUtils.readFileToString(file, "UTF-8").toLowerCase();

        Map<String, Integer> wordHashMap = new HashMap<>();
        String[] words = stringFromFile.split(" ");

        for (String word : words) {
            if (wordHashMap.containsKey(word)) {
                wordHashMap.put(word, wordHashMap.get(word) + 1);
            } else {
                wordHashMap.put(word, 1);
            }

        }

        for (Map.Entry<String, Integer> e : wordHashMap.entrySet()) {
            FileUtils.write(file, "\n" + e.getKey() + " = " + e.getValue(),
                    "UTF-8", true);
        }

        LOGGER.log(MENU_LOG, "File has been written");

        System.exit(0);
    }
}
