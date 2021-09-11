package ru.geekbrains;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Network network;

    @FXML
    public VBox leftPanel, rightPanel;
    @FXML
    public Button copyButton, moveButton, removeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        network = new Network();
    }


    public void buttonAction(ActionEvent actionEvent) {
        network.sendMessage("");
    }

    public void btnExitAction() {
        Platform.exit();
    }
}