package controllers;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseProfileController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void createProfile() throws IOException {
        Scene scene = FXMLLoader.load(getClass().getResource(Main.VIEWS + "CreateProfile.fxml"));
        Main.stage.setScene(scene);
    }
}
