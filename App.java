import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import javafx.scene.text.*;
import javafx.scene.paint.Color;

import java.util.Locale;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        Bank bank = new Bank();
        Controller controller = new Controller(bank);

        Scene scene = new Scene(controller.getView());
        stage.setTitle("Bank");
        stage.setScene(scene);
        controller.viewAktuallisieren();
        stage.show();
    }

}
