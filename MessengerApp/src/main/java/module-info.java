module com.example.messengerapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.messengerapp to javafx.fxml;
    exports com.example.messengerapp;
}