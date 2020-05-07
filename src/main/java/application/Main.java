package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static String VIEWS = "/views/";

    public static Stage stage;
    public static Scene scene;
    public static AnchorPane pane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane primaryPane = FXMLLoader.load(getClass().getResource(VIEWS + "ChooseProfile.fxml"));
        Scene primaryScene = new Scene(primaryPane);

        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Tempwear");
        primaryStage.show();

        setStage(primaryStage);
        setScene(primaryScene);
        setPane(primaryPane);

        scene.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> {
            Scale scale = new Scale(newSceneWidth.doubleValue()/oldSceneWidth.doubleValue(), 1, 0, 0);
            pane.getTransforms().add(scale);
            stage.show();

        });
        scene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> {
            Scale scale = new Scale(1, newSceneHeight.doubleValue()/oldSceneHeight.doubleValue(), 0, 0);
            pane.getTransforms().add(scale);
            stage.show();
        });
    }

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setScene(Scene primaryScene) {
        scene = primaryScene;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setPane(AnchorPane primaryPane) {
        pane = primaryPane;
    }

    public static AnchorPane getPane() {
        return pane;
    }
}
