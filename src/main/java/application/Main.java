package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static String VIEWS = "/views/";

    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = FXMLLoader.load(getClass().getResource(VIEWS + "ChooseProfile.fxml"));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Tempwear");
        primaryStage.show();

        setStage(primaryStage);
    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }
}
