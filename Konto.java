
class Konto
{
    // Attribute
    int kontonummer;
    double kontostand;
    String inhaber;

    // Konstruktor
    Konto(int nummer_, String inhaber_)
    {
        kontonummer = nummer_;
        inhaber = inhaber_;
        kontostand = 0;       
    }

    // Methoden
    void setKontostand(double kontostand_)
    {
        kontostand = kontostand_;
    }

    void infosDrucken()
    {
        System.out.println("----- Konto ----");
        System.out.println("Kontonummer: " + kontonummer);
        System.out.println("Inhaber: " + inhaber);
        System.out.println("Kontostand: " + kontostand);
    }

    int getKontonummer()
    {
        return kontonummer;
    }

    // Hier müssen die Getter für inhaber und kontostand hin!
    
    
    // Diese Methoden müssen auch noch ergänzt werden!
    void einzahlen (double betrag)
    {
        // hier muss etwas ergänzt werden
       
    }

    void abheben (double betrag)
    {
        // hier muss etwas ergänzt werden
   
    }

}
