package ru.geekbrains.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ru.geekbrains.Network;

import java.net.URL;
import java.util.ResourceBundle;

public class JointController implements Initializable {

    private Network network;

    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Button signInButton;
    @FXML
    public GridPane gridPane;
    public static GridPane gridPaneForClose;
    public static TextField loginFieldForClose;
    public static PasswordField passwordFieldForClose;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        network = new Network();
    }


    public void signIn() {
        if (checkingForCompletenessOfLines()) {
            network.sendMessage("/auth " + loginField.getText() + " " + passwordField.getText());
            gridPaneForClose = gridPane;
            loginFieldForClose = loginField;
            passwordFieldForClose = passwordField;
        }
    }

    private boolean checkingForCompletenessOfLines() {
        if (loginField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Login and password field must be filled", ButtonType.OK);
            alert.showAndWait();
            loginField.clear();
            passwordField.clear();
            return false;
        }
        return true;
    }

    public static void authFailWindow() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong login or password", ButtonType.OK);
        alert.showAndWait();
        loginFieldForClose.clear();
        passwordFieldForClose.clear();
    }

    public static void closeWindow() {
        ((Stage) gridPaneForClose.getScene().getWindow()).close();
    }

}
