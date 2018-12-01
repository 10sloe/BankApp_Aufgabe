
/**
 * Beschreiben Sie hier die Klasse Bank.
 * 
 * @author sloe 
 * @version 1.0
 */
public class Bank
{

    // Attribute
    Konto[] kontos;
    int anzahl;

    public Bank()
    {
        anzahl = 4;
        kontos = new Konto[anzahl];
        kontos[0] = new Konto(11,"Anna");
        kontos[1] = new Konto(24,"Bernd");
        kontos[2] = new Konto(31,"Carl");
        kontos[3] = new Konto(45, "Doris");
        kontos[0].einzahlen(82);
        kontos[1].einzahlen(61);
        kontos[2].einzahlen(33);
    }

    public void alleKontenAusgeben()
    {
        for (int i = 0; i < anzahl; i++)
        {
            kontos[i].infosDrucken();
            System.out.println();   
        }
    }

    public void ueberweisung(int von, int zu, double betrag)
    {
        findeKonto(von).abheben(betrag);
        findeKonto(zu).einzahlen(betrag);
    }

    public Konto findeKonto(int nummer)
    {
        for (int i = 0; i < anzahl; i++)
        {
            if (kontos[i].getKontonummer() == nummer)
            {
                return kontos[i];
            }
        }
        return null;
    }

    public Konto getKonto(int i)
    {
        return kontos[i];
    }

    public int kontoAnzahl()
    {
        return kontos.length;
    }

    public boolean kontonummergueltig(int nummer)
    {
        for (int i = 0; i < anzahl; i++)
        {
            if (kontos[i].getKontonummer() == nummer)
            {
                return true;
            }
        }
        return false;
    }
}
