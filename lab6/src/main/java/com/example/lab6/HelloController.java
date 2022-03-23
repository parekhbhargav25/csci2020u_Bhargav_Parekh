package com.example.lab6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private
    BarChart<String, Number> lineChart;

    @FXML
    private
    PieChart pieChart;

    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };

    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };


    //Just for the reference. Added value for x values, couldn't get it to work without any x values
    private static String[] yearList = {
            "2000","2001","2002","2003","2004","2005","2006","2007"
    };

    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };

    @FXML
    public void onSubmitButton(ActionEvent event) {
        lineChart.getData().clear();
        pieChart.getData().clear();
        XYChart.Series<String, Number> chart1 = new XYChart. Series<>();
        XYChart.Series<String, Number> chart2 = new XYChart. Series<>();
        chart1.setName("Average House Price");
        chart2.setName("Average Commercial Price");

        for(int i = 0; i<avgHousingPricesByYear.length; i++) {
            chart1.getData().add(new XYChart. Data<>(yearList[i], avgHousingPricesByYear[i]));
            chart2.getData().add(new XYChart. Data<>(yearList[i], avgCommercialPricesByYear[i]));
            //System.out.println(avgHousingPricesByYear[i]);
        }
        lineChart.getData().addAll(chart1,chart2);



        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart. Data( ageGroups[0], purchasesByAgeGroup[0]),
                new PieChart.Data( ageGroups[1], purchasesByAgeGroup[1]),
                new PieChart. Data(  ageGroups[2], purchasesByAgeGroup[2]),
                new PieChart. Data( ageGroups[3], purchasesByAgeGroup[3]),
                new PieChart. Data( ageGroups[4], purchasesByAgeGroup[4]),
                new PieChart. Data( ageGroups[5], purchasesByAgeGroup[5]));

        pieChart.getData().addAll(pieChartData);
    }



}