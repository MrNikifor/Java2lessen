package com.geekbrains.clientchat;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ClientChat extends Application {
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(ClientChat.class.getResource("hello-view.fxml"));

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        this.stage.setTitle("WELCOME");
        this.stage.setScene(scene);
        ClientController controller = fxmlLoader.getController();
        controller.userList.getItems().addAll("user1", "user2");

        stage.show();
        connectToServer(controller);
    }
    private void connectToServer(ClientController clientController) {
        Network network = new Network();
        boolean resultConnectedToServer = network.connect();
        if (!resultConnectedToServer) {
            String errorMessage = "Network connection cannot be established";
            System.err.println(errorMessage);
            showErrorDialog(errorMessage);
        }

        clientController.setNetwork(network);
        clientController.setApplication(this);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                network.close();
            }
        });
    }
    public void showErrorDialog(String message){
       Alert alert = new Alert(Alert.AlertType.ERROR);
       alert.setTitle("Error");
       alert.setContentText(message);
       alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}