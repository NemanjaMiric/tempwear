package controllers;

import application.Main;
import database.SQLiteConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.sqlite.SQLiteException;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateProfileController implements Initializable {

    @FXML
    private TextArea rulesTextArea;

    @FXML
    private ArrayList<CheckBox> checkBoxList;

    @FXML
    private TextField name;

    @FXML
    private ChoiceBox<String> gender;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onCheckBox() {
        StringBuilder rules = new StringBuilder();

        for (CheckBox checkBox : checkBoxList) {
            if (checkBox.isSelected())
                rules.append("\"").append(checkBox.getText()).append("\"").append(": {\n\n},\n");
        }

        if (rules.length() > 0)
            rules.setLength(rules.length() - 2);

        rulesTextArea.setText(String.valueOf(rules));
    }

    public void onCreateProfile() throws IOException, SQLException {
        Connection connection = SQLiteConnection.connector();
        assert connection != null;
        connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS profiles (name TEXT UNIQUE, gender TEXT, rules TEXT)"
        ).executeUpdate();

        try {
            connection.prepareStatement(
                    "INSERT INTO profiles VALUES ('"
                            + name.getText() + "', '"
                            + gender.getSelectionModel().getSelectedItem() + "', '"
                            + rulesTextArea.getText() + "')"
            ).executeUpdate();

            AnchorPane primaryPane = FXMLLoader.load(getClass().getResource(Main.VIEWS + "ChooseProfile.fxml"));
            Scene primaryScene = new Scene(primaryPane);

            Main.getStage().setScene(primaryScene);

            Main.setScene(primaryScene);
            Main.setPane(primaryPane);

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
        } catch (SQLiteException e) {
            Main.popup("Profile '" + name.getText() + "' already exists");
        }
    }
}
