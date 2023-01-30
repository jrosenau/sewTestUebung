import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.*;

public class HashMapWordCounter {
    public static void main(String[] args) {
        int count = 0;
        HashMap<Integer, String> wordCount = new HashMap<>();
        File testText = new File("src/testtext.txt");
        try{


        Scanner testTextScanner = new Scanner(testText);

        while(testTextScanner.hasNext()){
            String word = testTextScanner.next().replaceAll("\\.", "").toLowerCase();



            //String woerter = words[count];

            wordCount.put(count, word.replaceAll(",",""));
            count++;


        }
        testTextScanner.close();
        }catch(FileNotFoundException e){
            System.out.println("Der angegebene Dateipfad ist falsch.");
        }

        System.out.println(wordCount);
    }
}
