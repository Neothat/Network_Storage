package ru.geekbrains.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ru.geekbrains.Network;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController{

    private Network network;

    @FXML
    public VBox leftPanel, rightPanel;
    @FXML
    public Button copyButton, moveButton, removeButton;

    public void buttonAction(ActionEvent actionEvent) {
        network.sendMessage("");
    }

    public void btnExitAction() {
        Platform.exit();
    }
}