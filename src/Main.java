import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Auto>> autos = new HashMap<String, ArrayList<Auto>>();
        File autoListe = new File("src/autos.csv");
        try{
            Scanner autoScanner = new Scanner(autoListe);

        while(autoScanner.hasNextLine()){
            String line = autoScanner.nextLine();
            String[] daten = line.split(";");
             String Farbe = daten[0];
             String Marke = daten[1];
             String Modell = daten[2];

             Auto auto = new Auto(Marke, Modell);
             autos.put(Marke, new ArrayList<Auto>());
        }
        autoScanner.close();
        }catch (FileNotFoundException e){
            System.out.println("datei konnte nicht gefunden werden!");
        }

        System.out.println(autos.containsKey("Audi"));
    }
}