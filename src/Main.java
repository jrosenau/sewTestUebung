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
autoScanner.nextLine();
        while(autoScanner.hasNextLine()){
            String line = autoScanner.nextLine();
            String[] daten = line.split(";");
             String Farbe = daten[2];
             String Marke = daten[0];
             String Modell = daten[1];

             Auto auto = new Auto(Modell, Farbe, Marke);
             if (!autos.containsKey(Marke)){
                 autos.put(Marke, new ArrayList<Auto>());
             }
             autos.get(Marke).add(auto);
        }
        autoScanner.close();
        }catch (FileNotFoundException e){
            System.out.println("datei konnte nicht gefunden werden!");
        }

        ArrayList<Auto> audiAutos = autos.get("Ford");
        if (audiAutos != null) {
            for (Auto auto : audiAutos) {
                System.out.println(auto.toString());
            }
        }
    }
    }
