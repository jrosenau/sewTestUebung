public class Auto {
    private String Farbe;
    private String Marke;
    private int Geschwindigkeit;
    private String Modell;
    public Auto(String modell, String farbe, String marke) {
        Marke = marke;
        Farbe = farbe;


        Modell = modell;
    }



    @Override
    public String toString() {
        return ("Marke: " + Marke + " | Modell: " + Modell + " | Farbe: " + Farbe);
    }
}
