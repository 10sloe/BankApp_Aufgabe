
/**
 * Beschreiben Sie hier die Klasse UerberweisungView.
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

public class UeberweisungView extends GridPane
{
    TextField txtVon;
    TextField txtZu;
    TextField txtBetrag;
    Controller controller;
    Label lblFehler;

    public UeberweisungView(Controller contr_)
    {
        controller = contr_;
        guiErstellen();
    }

    public void guiErstellen()
    {

        // Erstellen der Elemente
        Text titel = new Text("Überweisung");
        titel.setFont(new Font(24));  // Der Titel ist nun größer!   

        Label lblVon = new Label("von" );    
        Label lblZu = new Label("zu");
        Label lblBetrag = new Label("Betrag");
        lblFehler = new Label("");

        txtVon = new TextField();    
        txtZu = new TextField();
        txtBetrag = new TextField();

        lblVon.setPrefWidth(100);
        lblZu.setPrefWidth(100);
        lblBetrag.setPrefWidth(100);

        txtVon.setPrefWidth(80);
        txtZu.setPrefWidth(80);
        txtBetrag.setPrefWidth(80);

        Button button = new Button("ausführen");
        button.setOnAction(e -> ueberweisungAusfuehren());

        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));

        add(titel, 0, 0, 2, 1);
        add(lblVon, 0, 1);
        add(lblZu, 0, 2);
        add(lblBetrag, 0,3);
        add(lblFehler, 0,4,3,1);

        add(txtVon, 1, 1);
        add(txtZu, 1, 2);
        add(txtBetrag, 1,3);
        add(button,2,3);

        setBackground(new Background(new BackgroundFill(Color.WHITE
                , CornerRadii.EMPTY, new Insets(3))));
        txtVon.requestFocus();
    }

    public void ueberweisungAusfuehren()
    {
        try {

            int nr1 = Integer.parseInt(txtVon.getText()); 
            int nr2 = Integer.parseInt(txtZu.getText());
            double betrag = Double.parseDouble(txtBetrag.getText());
            if (!controller.ueberweisungAusfuehren(nr1, nr2, betrag))
            {
                lblFehler.setText("Fehler! Falsche Kontonummer");
            }

        }
        catch(Exception ex)
        {
            zuruecksetzen();
        }
    }

    public void zuruecksetzen()
    {
        txtVon.setText("");
        txtZu.setText("");
        txtBetrag.setText("");
        txtVon.requestFocus();
        lblFehler.setText("");
    }
}
