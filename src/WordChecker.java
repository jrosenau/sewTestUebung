import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordChecker {
    public static void main(String[] args) {
        Set<String> wordsInFile1 = new HashSet<>();
        Set<String> wordsInFile2 = new HashSet<>();

        // Lesen Sie die Wörter aus dem ersten Textfile
        try (Scanner scanner = new Scanner(new File("src/first_file.txt"))) {
            while (scanner.hasNext()) {
                wordsInFile1.add(scanner.next().replaceAll(",",""));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: file1.txt");
        }

        // Lesen Sie die Wörter aus dem zweiten Textfile
        try (Scanner scanner = new Scanner(new File("src/second_file.txt"))) {
            while (scanner.hasNext()) {
                wordsInFile2.add(scanner.next().replaceAll(",",""));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: file2.txt");
        }

        // Verwenden Sie eine Intersektion, um die gemeinsamen Wörter zu erhalten
        Set<String> commonWords = new HashSet<>(wordsInFile1);
        commonWords.retainAll(wordsInFile2);

        // Geben Sie die gemeinsamen Wörter aus
        System.out.println("Gemeinsame Wörter: " + commonWords);
    }
}