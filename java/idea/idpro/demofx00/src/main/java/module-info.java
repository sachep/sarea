module com.example.demofx00 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demofx00 to javafx.fxml;
    exports com.example.demofx00;
}