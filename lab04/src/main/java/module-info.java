module com.example.lab04 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.lab04 to javafx.fxml;
    exports com.example.lab04;
}