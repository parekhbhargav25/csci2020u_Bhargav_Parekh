module com.example.midtermcsci2020u {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.desktop;


    opens com.example.midtermcsci2020u to javafx.fxml;
    exports com.example.midtermcsci2020u;
}