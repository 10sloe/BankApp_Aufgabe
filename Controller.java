
/**
 * Beschreiben Sie hier die Klasse Controller.
 * 
 * @author sloe 
 * @version (eine Versionsnummer oder ein Datum)
 */

import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import javafx.scene.text.*;
import javafx.scene.paint.Color;

import java.util.Locale;

public class Controller
{
    private Bank bank;
    BankView bankView;

    public Controller(Bank bank_)
    {
        bank = bank_;
        bankView = new BankView(bank, this);
    }

    public Pane getView()
    {
        return bankView;
    }

    public boolean ueberweisungAusfuehren(int nr1, int nr2, double betrag)
    {        
        if (bank.kontonummergueltig(nr1) && bank.kontonummergueltig(nr2))
        {  
            bank.ueberweisung(nr1,nr2,betrag);
            //bank.alleKontenAusgeben();
            bankView.aktuallisieren();
            return true;
        }
        return false;
    }

    public void viewAktuallisieren()
    {
        bankView.aktuallisieren();
    }

}
