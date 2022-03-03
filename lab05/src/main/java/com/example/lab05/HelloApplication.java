package com.example.lab05;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.IOException;

public class HelloApplication extends Application {

    Stage window;
    TableView<StudentRecord> studentTable;



    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("Student Record");


        //Naming column
        TableColumn<StudentRecord, String> IdColumn = new TableColumn<>("SID");
        IdColumn.setMinWidth(100);
        IdColumn.setCellValueFactory(new PropertyValueFactory<>("StudentID"));

        TableColumn<StudentRecord, Float> AssignmentColumn = new TableColumn<>("Assignments");
        AssignmentColumn.setMinWidth(100);
        AssignmentColumn.setCellValueFactory(new PropertyValueFactory<>("AssignmentMark"));

        TableColumn<StudentRecord, Double> MidtermColumn = new TableColumn<>("Midterm");
        MidtermColumn.setMinWidth(100);
        MidtermColumn.setCellValueFactory(new PropertyValueFactory<>("midtermMark"));


        TableColumn<StudentRecord, Float> finalExamColumn = new TableColumn<>("Final Exam");
        finalExamColumn.setMinWidth(100);
        finalExamColumn.setCellValueFactory(new PropertyValueFactory<>("ExamMark"));

        TableColumn<StudentRecord, Double> finalMarkColumn = new TableColumn<>("Final Mark");
        finalMarkColumn.setMinWidth(100);
        finalMarkColumn.setCellValueFactory(new PropertyValueFactory<>("FinalMark"));

        TableColumn<StudentRecord, Double> gradeColumn = new TableColumn<>("Letter Grade");
        gradeColumn.setMinWidth(100);
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("Grade"));


        studentTable = new TableView<>();
        studentTable.setItems(getAllMarks());
        studentTable.getColumns().addAll(IdColumn,AssignmentColumn,MidtermColumn,finalExamColumn,finalMarkColumn,gradeColumn);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(studentTable);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();

    }
        public ObservableList<StudentRecord> getAllMarks() {
            ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

            marks.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
            marks.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
            marks.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
            marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
            marks.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
            marks.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
            marks.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
            marks.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
            marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
            marks.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));

            return marks;
        }

    public static void main(String[] args) {

        launch();
    }



}