import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WortVergleich {
    public static void main(String[] args) {
        HashSet<String> first_file = new HashSet<>();
        HashSet<String> second_file = new HashSet<>();
        File firstFile = new File("src/first_file.txt");
        File secondFile = new File("src/second_file.txt");
        try{
            Scanner scanner = new Scanner(firstFile);
            while(scanner.hasNext()){
                first_file.add(scanner.next().replaceAll(",",""));
            }
            scanner.close();
        }catch(FileNotFoundException e){
            System.out.println("first_file.txt konnte nicht gefunden werden!");
        }
        try{
            Scanner scanner = new Scanner(secondFile);
            while(scanner.hasNext()){
                second_file.add(scanner.next().replaceAll(",",""));
            }
            scanner.close();
        }catch(FileNotFoundException e){
            System.out.println("second_file.txt konnte nicht gefunden werden!");
        }
        HashSet<String> gemeinsamkeiten = new HashSet<>(first_file);
        gemeinsamkeiten.retainAll(second_file);
        System.out.println("Die folgenden Strings kommen in beiden Files vor: " + gemeinsamkeiten);
    }
}
