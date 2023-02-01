import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapWortZaehler {



    public static void main(String[] args) {
        HashMap<String, Integer> wordCounts = new HashMap<>();
File testText = new File("src/testtext.txt");
        try{


                Scanner scanner = new Scanner(testText);
            while (scanner.hasNext()) {
                String line = scanner.next();
                // split the line into words and increment the count for each word
                String[] words = line.split(" ");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (wordCounts.containsKey(word)) {
                        wordCounts.put(word, wordCounts.get(word) + 1);
                    } else {
                        wordCounts.put(word, 1);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
File newFile = new File("src/new_file.txt");
        try {

            FileWriter writer = new FileWriter(newFile);

            wordCounts.forEach((word, count) -> {

                if (word.length() > 3 && count >= 3) {
                    try {
                        writer.append("Wort: " + word + " | Häufigkeit: " + count + "\n");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}