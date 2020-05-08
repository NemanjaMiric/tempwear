package controllers;

import application.Main;
import database.SQLiteConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import org.sqlite.SQLiteException;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ChooseProfileController implements Initializable {

    @FXML
    private TextField profileName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void recommend() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource(Main.VIEWS + "Recommend.fxml"));
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

    public void editProfile() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource(Main.VIEWS + "EditProfile.fxml"));
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

    public void deleteProfile() throws SQLException {
        Connection connection = SQLiteConnection.connector();
        assert connection != null;
        try {
            ResultSet prepareStatement = connection.prepareStatement(
                    "SELECT * FROM profiles WHERE name = '" + profileName.getText() + "';"
            ).executeQuery();

            if (prepareStatement.next()) {
                connection.prepareStatement(
                        "DELETE FROM profiles WHERE name = '" + profileName.getText() + "';"
                ).executeUpdate();
            } else {
                Main.popup("Profile '" + profileName.getText() + "' doesn't exist");
            }
        } catch (SQLiteException e) {
            Main.popup("Profile '" + profileName.getText() + "' doesn't exist");
        }
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
