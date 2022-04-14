package com.example.lab10;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Server implements Initializable {
    @FXML
    private TextArea serverArea;
    @FXML
    private Button serverExitButton;

    public void initialize(URL location, ResourceBundle resources)  {
        serverArea.setEditable(false);
        String timestamp = new SimpleDateFormat("h:mm").format(new Date());
        //Create new thread for server
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Initializing server socket
                    ServerSocket server = new ServerSocket(1234);
                    Socket socket = server.accept();
                    while(true) {
                        //Socket socket = server.accept();
                        BufferedReader inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String message;
                        while((message = inStream.readLine()) != null) {
                            serverArea.appendText(timestamp + " :" + message + "\n\n");
                        }
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
    }
    @FXML
    protected void onExit() {
        Stage stage = (Stage) serverExitButton.getScene().getWindow();
        stage.close();
    }
}
