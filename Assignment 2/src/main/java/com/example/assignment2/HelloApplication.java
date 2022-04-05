package com.example.assignment2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1500, 700);
        stage.setTitle("Assignment 2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();

        Map<String, String> Hmap = new HashMap<>();
        Map<String, String> Hmap2 = new HashMap<>();
         Map<String, String> Hmap3 = new HashMap<>();
         Map<String, String> Hmap4 = new HashMap<>();
         Map<String, String> Hmap5 = new HashMap<>();
         Map<String, String> Hmap6 = new HashMap<>();
         Map<String, String> Hmap7 = new HashMap<>();

        String xml_path = "src/main/resources/com/example/assignment2/converted_airline_safety.xml";
        String path = "src/main/resources/com/example/assignment2/airline_safety.csv";
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document doc;
        String line;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.newDocument();
            //add elements to Document
            Element rootElement =
                    doc.createElementNS(" ", "Airline_Safety");
            //append root element to document
            doc.appendChild(rootElement);

            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while( (line = br.readLine()) != null) {
                    String[] lineValue = line.split(",");
                    for(int i = 1; i < lineValue.length; i++) {
                        String key = lineValue[0];
                        if (Hmap.containsKey(key)) {
                            String value = lineValue[1]; //Column 1
                            String value2 = lineValue[2]; //Column 2
                            String value3 = lineValue[3]; //Column 3
                            String value4 = lineValue[4]; //Column 4
                            String value5 = lineValue[5]; //Column 5
                            String value6 = lineValue[6]; //Column 6
                            String value7 = lineValue[7]; //Column 6
                            Hmap.put(key, value);
                            Hmap2.put(key, value2);
                            Hmap3.put(key, value3);
                            Hmap4.put(key, value4);
                            Hmap5.put(key, value5);
                            Hmap6.put(key, value6);
                            Hmap7.put(key, value7);
                        } else {
                            Hmap.put(key, "");
                            Hmap2.put(key, "");
                            Hmap3.put(key, "");
                            Hmap4.put(key, "");
                            Hmap5.put(key, "");
                            Hmap6.put(key, "");
                            Hmap7.put(key, "");

                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //append elements to root element
            for(String key: Hmap.keySet()){
                rootElement.appendChild(getAirInfo(doc,  key ,Hmap.get(key), Hmap2.get(key), Hmap3.get(key), Hmap4.get(key), Hmap5.get(key), Hmap6.get(key), Hmap7.get(key)));
            }

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(xml_path));

            //write data
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private static Node getAirInfo (Document doc, String airName, String km_wk, String i_85_99,String fa_85_99, String f_85_99, String i_00_14, String fa_00_14, String f_00_14){
        Element employee = doc.createElement("AirlineInfo");

        //create name element
        employee.appendChild(getAirInfoElements(doc, employee, "airline", airName));

        //create age element
        employee.appendChild(getAirInfoElements(doc, employee, "avail_seat_km_per_week", km_wk));

        //create role element
        employee.appendChild(getAirInfoElements(doc, employee, "incidents_85_99", i_85_99));
        employee.appendChild(getAirInfoElements(doc, employee, "fatal_accidents_85_99", fa_85_99));
        //create gender element
        employee.appendChild(getAirInfoElements(doc, employee, "fatalities_85_99", f_85_99));

        employee.appendChild(getAirInfoElements(doc, employee, "incidents_00_14", i_00_14));

        employee.appendChild(getAirInfoElements(doc, employee, "fatal_accidents_00_14", fa_00_14));

        employee.appendChild(getAirInfoElements(doc, employee, "fatalities_00_14", f_00_14));

        return employee;
    }


    //utility method to create text node
    private static Node getAirInfoElements (Document doc, Element element, String name, String value){
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    }


