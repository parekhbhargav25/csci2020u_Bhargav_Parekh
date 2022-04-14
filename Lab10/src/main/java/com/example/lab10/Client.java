package com.example.lab10;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Client {
    @FXML
    private TextField userNameField;
    @FXML
    private TextField messageField;
    @FXML
    private Button exitButton;

    private Socket clientSocket;
    private PrintWriter clientToServerWriter;

    @FXML
    private Button sendButton;
   @FXML
    protected void onSend() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    clientSocket = new Socket("localhost", 1234);

                    clientToServerWriter = new PrintWriter(clientSocket.getOutputStream());

                    messageField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent KE) {
                            sendButton.setDisable(true);
                            if (KE.getCode().equals(KeyCode.ENTER)) {
                                clientToServerWriter.println(userNameField.getText() + " : " +messageField.getText());
                                clientToServerWriter.flush();
                                messageField.clear();
                            }
                        }
                    });
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

    @FXML
    protected void onExit() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
