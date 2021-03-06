package com.example.midtermcsci2020u;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        //stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


//    private static final String FILENAME = "src/main/resources/com/example/midtermcsci2020u/file.xml";
    public static void main(String[] args) {

        launch();
    }
}