import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class FileWortZaehler {
    public static void main(String[] args) {
        HashMap<String, Integer> wortZaehler = new HashMap<>();
        File inputFile = new File("src/testtext.txt");
        File outputFile = new File("src/gezaehlteWorte.txt");

        try{
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNext()){
                String line = scanner.next();
                String[] woerter = line.split(",|\\.");
                for (String wort : woerter) {
                    if(wortZaehler.containsKey(wort)){
                        wortZaehler.put(wort, wortZaehler.get(wort) + 1);
                    }else{
                        wortZaehler.put(wort, 1);
                    }

                }
            }
scanner.close();
        }catch (FileNotFoundException e){
            System.out.println("falscher Dateipfad/Datei konnte nicht gefunden werden");
        }
        try{
            FileWriter writer = new FileWriter(outputFile);
            wortZaehler.forEach((word, count) -> {
                if(word.length() > 3 && count >= 3){

                    try {
                        writer.append(word + " | " + count + "\n");
                    } catch (IOException e) {
                        System.out.println("falscher Dateipfad/Datei konnte nicht gefunden werden");
                    }
                }
            });
            writer.close();
        }catch(IOException e){
            System.out.println("falscher Dateipfad/Datei konnte nicht gefunden werden");
        }
/*try{
    FileWriter writer = new FileWriter(outputFile);
    wortZaehler.forEach((word, count) -> {

        if (word.length() > 3 && count >= 3) {
            try {
                writer.append("Wort: " + word + " | Häufigkeit: " + count + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
    writer.close();
}catch(IOException e){
    System.out.println("Datei konnte nicht erstellt werden!");
}
*/
    }
}