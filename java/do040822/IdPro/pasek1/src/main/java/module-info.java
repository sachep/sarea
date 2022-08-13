module com.example.pasek1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pasek1 to javafx.fxml;
    exports com.example.pasek1;
}