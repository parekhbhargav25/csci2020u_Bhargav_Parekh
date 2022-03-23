package com.example.midtermcsci2020u;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.util.Duration;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    private Parent root2;
    @FXML
    private Label Name;
    @FXML
    private Label Email;
    @FXML
    private Label DESC;
    @FXML
    private Label stdID;


    @FXML
    public void SwithcScene(ActionEvent ae) throws IOException {
         root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
         stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
         stage.setTitle("Midterm Assignment");
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    private static final String FILENAME = "src/main/resources/com/example/midtermcsci2020u/file.xml";

    @FXML
    public void SwithcScene2(ActionEvent ae) throws IOException, ParserConfigurationException, SAXException {
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        stage.setTitle("Midterm Assignment");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void showInfo(ActionEvent ae) throws IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));

            doc.getDocumentElement().normalize();


            NodeList list = doc.getElementsByTagName("student");

            int temp = 0;
            org.w3c.dom.Node node = list.item(temp);

            if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {

                Element element = (Element) node;

                String id = element.getAttribute("id");

                // get text
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String email = element.getElementsByTagName("email").item(0).getTextContent();
                String desc = element.getElementsByTagName("description").item(0).getTextContent();

                Name.setText(name);
                Email.setText(email);
                DESC.setText(desc);
                stdID.setText(id);

            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @FXML //Code available in FXML file called Scene4,fxml
    public void SwitchScene4(ActionEvent ae) throws IOException, ParserConfigurationException, SAXException {
        root = FXMLLoader.load(getClass().getResource("scene4.fxml"));
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        stage.setTitle("Midterm Assignment");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    TranslateTransition transition;
    @FXML
    private Circle circle;


    @FXML
    public void PlayCircle(ActionEvent ae) {
        transition.play();

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        transition = new TranslateTransition();
        transition.setNode (circle);
        transition.setByX(500);
        transition.setDuration (Duration.millis(2000));
        transition.setAutoReverse (true);
        transition.setCycleCount (2);

    }

    @FXML //Code available in FXML file called Scene4,fxml
    public void SwitchScene3(ActionEvent ae) throws IOException, ParserConfigurationException, SAXException {
        root = FXMLLoader.load(getClass().getResource("scene5Trial.fxml"));
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        stage.setTitle("Midterm Assignment");

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}