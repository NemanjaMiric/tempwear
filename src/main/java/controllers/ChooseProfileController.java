package controllers;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseProfileController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void createProfile() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource(Main.VIEWS + "CreateProfile.fxml"));
        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);

        Main.setScene(scene);
        Main.setPane(root);

        Main.getScene().widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> {
            Scale scale = new Scale(newSceneWidth.doubleValue()/oldSceneWidth.doubleValue(), 1, 0, 0);
            Main.getPane().getTransforms().add(scale);
            Main.getStage().show();

        });
        Main.getScene().heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> {
            Scale scale = new Scale(1, newSceneHeight.doubleValue()/oldSceneHeight.doubleValue(), 0, 0);
            Main.getPane().getTransforms().add(scale);
            Main.getStage().show();
        });
    }
}
