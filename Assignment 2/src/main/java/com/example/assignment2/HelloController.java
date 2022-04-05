package com.example.assignment2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class HelloController implements Initializable {

    @FXML
    private
    BarChart<String, Number> barchart;


    public Map<String, Long> map = new HashMap<>();
    public Map<String, Integer> map2 = new HashMap<>();
    public Map<String, Integer> map3 = new HashMap<>();
    public Map<String, Integer> map4 = new HashMap<>();
    public Map<String, Integer> map5 = new HashMap<>();
    public Map<String, Integer> map6 = new HashMap<>();
    public Map<String, Integer> map7 = new HashMap<>();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String, Number> chart1 = new XYChart. Series<>();
        XYChart.Series<String, Number> chart2 = new XYChart. Series<>();

        chart1.setName("Fatal accidents between 1985 – 1999");
        chart2.setName("Fatal accidents between 2000 – 2014");

        String path = "src/main/resources/com/example/assignment2/airline_safety.csv";
        String xmlPath = "src/main/resources/com/example/assignment2/airline_summary_statistic.xml";
        String line;

        // Reading from the CSV file and storing those value into hashMap
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while( (line = br.readLine()) != null) {
                String[] lineValue = line.split(",");
                for(int i = 1; i < lineValue.length; i++) {
                    String key = lineValue[0];
                    if (map3.containsKey(key)) {
                        String value = lineValue[1]; //Column 1
                        String value2 = lineValue[2]; //Column 2
                        String value3 = lineValue[3]; //Column 3
                        String value4 = lineValue[4]; //Column 4
                        String value5 = lineValue[5]; //Column 5
                        String value6 = lineValue[6]; //Column 6
                        String value7 = lineValue[7]; //Column 6


                        //condition ? value : otherValue
                        map.put(key, Long.valueOf(value));
                        map2.put(key, Integer.valueOf(value2));
                        map3.put(key, Integer.valueOf(value3));
                        map4.put(key, Integer.valueOf(value4));
                        map5.put(key, Integer.valueOf(value5));
                        map6.put(key, Integer.valueOf(value6));
                        map7.put(key, Integer.valueOf(value7));

                    } else {
                        map.put(key, 0L);
                        map2.put(key, 0);
                        map3.put(key, 0);
                        map4.put(key, 0);
                        map5.put(key, 0);
                        map6.put(key, 0);
                        map7.put(key, 0);

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Had to manually remove these because it was causing problem when i was converting from String to Int and the column name also was in map
        map.remove("airline");
        map2.remove("airline");
        map3.remove("airline");
        map4.remove("airline");
        map5.remove("airline");
        map6.remove("airline");
        map7.remove("airline");
//
        for(String key: map3.keySet()){
//            if (map3.containsKey("Vietnam Airlines")) {
//                System.out.println("Hello");
//            }
            chart1.getData().add(new XYChart. Data<>(key, Integer.parseInt(String.valueOf(map3.get(key)))));
            chart2.getData().add(new XYChart. Data<>(key, Integer.parseInt(String.valueOf(map6.get(key)))));


        }
        barchart.getData().addAll(chart1,chart2);



        /////      Summarize the Data (5%) ///////////////////////////////////////////////////////////////////////////////////
        long sum = 0;
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;
        double sum5 = 0;
        double sum6 = 0;
        double sum7 = 0;
        // Getting keys of column which corresponds to maximum value
        String MaxKey= Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Maxkey2 = Collections.max(map2.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Maxkey3 = Collections.max(map3.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Maxkey4 = Collections.max(map4.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Maxkey5 = Collections.max(map5.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Maxkey6 = Collections.max(map6.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Maxkey7 = Collections.max(map7.entrySet(), Map.Entry.comparingByValue()).getKey();

        // Getting keys of column which corresponds to minimum value
        String Minkey= Collections.min(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Minkey2 = Collections.min(map2.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Minkey3 = Collections.min(map3.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Minkey4 = Collections.min(map4.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Minkey5 = Collections.min(map5.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Minkey6 = Collections.min(map6.entrySet(), Map.Entry.comparingByValue()).getKey();
        String Minkey7 = Collections.min(map7.entrySet(), Map.Entry.comparingByValue()).getKey();

//        System.out.println(MaxKey);
//        System.out.println(map2.get(Maxkey2));

        for (Long value: map.values()) {
            sum += Long.parseLong(String.valueOf(value));
        }
        for (Integer value: map2.values()) {
            sum2 += Integer.parseInt(String.valueOf(value));
        }
        for (Integer value: map3.values()) {
            sum3 += Integer.parseInt(String.valueOf(value));
        }
        for (Integer value: map4.values()) {
            sum4 += Integer.parseInt(String.valueOf(value));
        }
        for (Integer value: map5.values()) {
            sum5 += Integer.parseInt(String.valueOf(value));
        }
        for (Integer value: map6.values()) {
            sum6 += Integer.parseInt(String.valueOf(value));
        }
        for (Integer value: map7.values()) {
            sum7 += Integer.parseInt(String.valueOf(value));
        }
        System.out.println("The average number of incidents between 1985 – 1999 across all airlines is "+ sum3/map3.size());
        System.out.println("The average number of incidents between 2000 – 2014 across all airlines is "+ sum6/map6.size());

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            //add elements to Document
            Element rootElement = doc.createElementNS("", "Summary");
            //append root element to document
            doc.appendChild(rootElement);

            // Calculate min, max and avg for each columns
            rootElement.appendChild(getStats(doc, "avail_seat_km_per_week", Double.parseDouble(String.valueOf(map.get(Minkey))), Double.parseDouble(String.valueOf(map.get(MaxKey))), sum/map.size()));
            rootElement.appendChild(getStats(doc, "incidents_85_99", Double.parseDouble(String.valueOf(map2.get(Minkey2))), Double.parseDouble(String.valueOf(map2.get(Maxkey2))), sum2/map2.size()));
            rootElement.appendChild(getStats(doc, "fatal_accidents_85_99", Double.parseDouble(String.valueOf(map3.get(Minkey3))), Double.parseDouble(String.valueOf(map3.get(Maxkey3))), sum3/map3.size()));
            rootElement.appendChild(getStats(doc, "fatalities_85_99", Double.parseDouble(String.valueOf(map4.get(Minkey4))), Double.parseDouble(String.valueOf(map4.get(Maxkey4))), sum4/map4.size()));
            rootElement.appendChild(getStats(doc, "incidents_00_14", Double.parseDouble(String.valueOf(map5.get(Minkey5))), Double.parseDouble(String.valueOf(map5.get(Maxkey5))), sum5/map5.size()));
            rootElement.appendChild(getStats(doc, "fatal_accidents_00_14", Double.parseDouble(String.valueOf(map6.get(Minkey6))), Double.parseDouble(String.valueOf(map6.get(Maxkey6))), sum6/map6.size()));
            rootElement.appendChild(getStats(doc, "fatalities_00_14", Double.parseDouble(String.valueOf(map7.get(Minkey7))), Double.parseDouble(String.valueOf(map7.get(Maxkey7))), sum7/map7.size()));

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(xmlPath));

            //write data
            //transformer.transform(source, console);
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Node getStats(Document doc, String name, double min, double max, double avg) {
        Element SummaryInfo = doc.createElement("Stat");
        //create name element
        SummaryInfo.appendChild(getSummeryElements(doc, SummaryInfo, "Name", name));
        //create min element
        SummaryInfo.appendChild(getSummeryElements(doc, SummaryInfo, "Min", String.valueOf(min)));
        //create max element
        SummaryInfo.appendChild(getSummeryElements(doc, SummaryInfo, "Max", String.valueOf(max)));
        //create avg element
        SummaryInfo.appendChild(getSummeryElements(doc, SummaryInfo, "Avg", String.valueOf(avg)));
        return SummaryInfo;
    }


    //utility method to create text node
    private static Node getSummeryElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}


