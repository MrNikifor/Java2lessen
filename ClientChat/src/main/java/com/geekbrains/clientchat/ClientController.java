package com.geekbrains.clientchat;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.function.Consumer;

public class ClientController {

    @FXML
    public TextArea chatTextArea;
    @FXML
    public Button sendMessageButton;
    @FXML
    public TextField messageTextArea;
    @FXML
    public ListView userList;

    private Network network;
    private ClientChat application;

    public void sendMessage(){
        String message = messageTextArea.getText();
        chatTextArea.appendText(DateFormat.getDateTimeInstance().format(new Date()) + " ");
        messageTextArea.requestFocus();
        appendMessageToChat(message);
        try {
            network.sendMessage(message);
        } catch (IOException e) {
            application.showErrorDialog("Error when transmitting data over the network");
        }

    }

    public void appendMessageToChat(String message) {    // метод вывода текста из набора текста(TextField) в окно чата(TextArea).
       if (!message.isEmpty()){
           chatTextArea.appendText(message);
           chatTextArea.appendText(System.lineSeparator());
           messageTextArea.clear();
       }
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
        network.waitMessage(new Consumer<String>() {
            @Override
            public void accept(String message) {
                appendMessageToChat(message);
            }
        });
    }

    public ClientChat getApplication() {
        return application;
    }

    public void setApplication(ClientChat application) {
        this.application = application;
    }
}
