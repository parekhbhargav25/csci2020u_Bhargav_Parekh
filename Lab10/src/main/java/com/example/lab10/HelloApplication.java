package com.example.lab10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Stage serverStage = new Stage();
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("server.fxml"));
        Scene Serverscene = new Scene(fxmlLoader2.load(), 400, 300);
        serverStage.setTitle("Server window!");
        serverStage.setScene(Serverscene);
        serverStage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("client.fxml"));
        Scene Clientscene = new Scene(fxmlLoader.load(), 500, 350);
        stage.setTitle("The client window!");
        stage.setScene(Clientscene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}