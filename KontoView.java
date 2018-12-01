
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

public class KontoView extends GridPane
{
    private Konto konto;
    private TextField txtStand;

    public KontoView(Konto konto_)
    {
        konto = konto_;
        guiErstellen();
    }

    public void guiErstellen()
    {

        // Erstellen der Elemente
        Text titel = new Text("Konto " + konto.getKontonummer());
        titel.setFont(new Font(24));  // Der Titel ist nun größer!   

        //Label lblNummer = new Label("Nr." );    
        Label lblInhaber = new Label("Inhaber");
        Label lblStand = new Label("Kontostand");

        //TextField txtNummer = new TextField(""+ konto.getNummer());    
        TextField txtInhaber = new TextField(konto.getInhaber());
        txtStand = new TextField("" +konto.getKontostand());

        //lblNummer.setPrefWidth(100);
        lblInhaber.setPrefWidth(100);
        lblStand.setPrefWidth(100);

        //txtNummer.setPrefWidth(80);
        txtInhaber.setPrefWidth(80);
        txtStand.setPrefWidth(80);

        //txtNummer.setEditable(false);
        txtInhaber.setEditable(false);
        txtStand.setEditable(false);

        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));

        add(titel, 0, 0, 2, 1);
        //add(lblNummer, 0, 1);
        add(lblInhaber, 0, 1);
        add(lblStand, 0,2);

        //add(txtNummer, 1, 1);
        add(txtInhaber, 1, 1);
        add(txtStand, 1,2);

        setBackground(new Background(new BackgroundFill(Color.POWDERBLUE
                , new CornerRadii(5), new Insets(3))));
    }

    public void aktuallisieren()
    {
        txtStand.setText("" + konto.getKontostand());

    }
}
