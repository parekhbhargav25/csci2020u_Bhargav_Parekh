package com.example.lab07;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // clearing chart just in case
        pieChart.getData().clear();

        Map<String, Integer> map = new HashMap<String, Integer>();

        String path = "src/main/resources/com/example/lab07/weatherwarnings-2015.csv";
        String line = "";
        // Reading from the CSV file and storing those value into hashMap
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while( (line = br.readLine()) != null) {
                String[] lineValue = line.split(",");
                for(int i = 0; i < lineValue.length; i++) {
                    String key = lineValue[5];
                    if (map.containsKey(key)) {
                        int value = map.get(key);
                        map.put(key, value + 1);
                    } else {
                        map.put(key, 1);
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace ();
        }

        int i = 0;
        //iterating over hashmap key and creating piechart in the for loop
        for(String key: map.keySet()){
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data( key, map.get(key)));
            i++;
//            System.out.println(key);
            pieChart.getData().addAll(pieChartData);
        }
    }
}