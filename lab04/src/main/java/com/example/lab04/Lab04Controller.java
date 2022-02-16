package com.example.lab04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.time.LocalDate;

public class Lab04Controller {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField userName;
    @FXML
    private TextField pass;
    @FXML
    private TextField fullName;
    @FXML
    private TextField email;
    @FXML
    private TextField phonenum;
    @FXML
    private DatePicker dob;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public void onSubmitButton(ActionEvent event) {
        String username = userName.getText();
        String password = pass.getText();
        String fName = fullName.getText();
        String Email = email.getText();
        //String phoneNum = phonenum.getText();
        String number = (phonenum.getText()).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
        LocalDate DOB = dob.getValue();
//        String DOB = String.valueOf(dob.getValue());

        System.out.println(username);
        System.out.println(password);
        System.out.println(fName);
        System.out.println(Email);
        System.out.println(number);
        System.out.println(DOB);

    }
}