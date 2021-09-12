package ru.geekbrains.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.geekbrains.controllers.JointController;

import java.io.IOException;
import java.util.Objects;

public class ClientHandler extends SimpleChannelInboundHandler<String> {

    private String nickname;

    @Override
    public void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        if (s.startsWith("/authOk ")) {
            nickname = s.split("\\s")[1];

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Parent root;
                    try {
                        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("main.fxml")));
                        Stage stage = new Stage();
                        stage.setTitle(nickname + "'s storage");
                        stage.setScene(new Scene(root, 1100, 600));
                        stage.show();
                        JointController.closeWindow();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        if (s.startsWith("/authFail")) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    JointController.authFailWindow();
                }
            });
        }
    }
}
