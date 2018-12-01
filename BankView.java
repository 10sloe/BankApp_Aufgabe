
/**
 * Beschreiben Sie hier die Klasse KontoView.
 * 
 * @author sloe 
 * @version 1.0
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

public class BankView extends VBox
{
    private Bank bank;
    private KontoView[] kontoviews;
    private UeberweisungView uview;
    private int kontenanzahl;
    private Controller controller;

    public BankView(Bank bank_, Controller contr_)
    {
        bank = bank_;
        controller = contr_;
        kontenanzahl = bank.kontoAnzahl();
        kontoviews = new KontoView[kontenanzahl];
        guiErstellen();
    }

    public void guiErstellen()
    {
        // ------- Titel ------
        HBox titelBox = new HBox();
        Text titel = new Text("ITG-BANK");
        titel.setFont(new Font(28));
        titelBox.setPadding(new Insets(10));
        titelBox.getChildren().add(titel);
        titelBox.setBackground(new Background(new BackgroundFill(Color.WHITE
                , CornerRadii.EMPTY, new Insets(3))));

        // ------ Darstellung der Konten
        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(3); //preferred columns
        for (int i = 0; i < kontenanzahl; i++)
        {
            KontoView view = new KontoView(bank.getKonto(i));
            kontoviews[i] = view;
            tilePane.getChildren().add(view);
        }

        // ----- Überweisung

        HBox ueberBox = new HBox();
        uview = new UeberweisungView(controller);
        ueberBox.getChildren().add(uview);

        getChildren().add(titelBox);
        getChildren().add(tilePane);
        getChildren().add(uview);

        setPadding(new Insets(10));

    }

    public void aktuallisieren()
    {
        for (int i = 0; i < kontenanzahl; i++)
        {
            kontoviews[i].aktuallisieren();
        }
        uview.zuruecksetzen();

    }
}
