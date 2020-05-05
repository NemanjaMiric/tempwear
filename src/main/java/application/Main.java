package application;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static String NAME = "Tempwear";

    public static String FXMLS = "/fxml/";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(FXMLS + "ChooseProfile.fxml"));
        Scene scene = loader.load();

        stage.setScene(scene);
        stage.setTitle(NAME);
        stage.show();
    }
}
