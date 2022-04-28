package com.geekbrains.clientchat;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.text.DateFormat;
import java.util.Date;

public class ClientController {

    @FXML
    public TextArea messageTextArea;
    @FXML
    public Button sendMessageButton;
    @FXML
    public TextField messageField;
    @FXML
    public ListView userList;

    public void appendMessageToChat(ActionEvent actionEvent) {    // метод вывода текста из набора текста(TextField) в окно чата(TextArea).
        if (!messageField.getText().isEmpty()){    //  если строка ввода не пустая
            messageTextArea.appendText(DateFormat.getDateTimeInstance().format(new Date()));  // перед текстом добавляем формат даты
            messageTextArea.appendText(System.lineSeparator());    // перенос новой строки в окне чата
            if (!userList.getSelectionModel().isEmpty()){        // пишем конкретному users
                String sender = userList.getSelectionModel().getSelectedItem().toString();
                messageTextArea.appendText(sender + ": ");
            }else {
                messageTextArea.appendText("Я: ");
            }
            messageTextArea.appendText(messageField.getText().trim());    // ввод текста в окно чата из строки набора текста (trim(). обрезает пробелы в начале и в конце)
            messageTextArea.appendText(System.lineSeparator());    // перенос новой строки в окне чата
            messageTextArea.appendText(System.lineSeparator());    // перенос новой строки в окне чата
            requestFocus();
            messageField.clear();   // удаление текста с строки ввода после переноса его в окно чата
        }
    }
    public void requestFocus(){          // метод позволяющий возобновлять курсор постоянно в строке ввода текста
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                messageField.requestFocus();
            }
        });
    }
}
