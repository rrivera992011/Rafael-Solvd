import org.apache.commons.io.FileUtils;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("./HeyDiddleDiddle.txt");

        String stringFromFile = FileUtils.readFileToString(file, "UTF-8");

        Map<String, Integer> wordHashMap = new HashMap<>();
        String[] words = stringFromFile.split(" ");


        int i = 0;

        for (String word : words) {

            if (wordHashMap.containsKey(word)) {
                wordHashMap.put(word, wordHashMap.get(word) + 1);
            }
            else{
                wordHashMap.put(word, 1);
            }

            String wordsForPrint = words[i];
            i = i+1;

            FileUtils.write(file, "\n" + wordsForPrint + " = " + wordHashMap.get(word),
                    "UTF-8", true);
        }




    }
}