module yon.de.beesa {
    requires javafx.controls;
    requires javafx.fxml;


    opens yon.de.beesa to javafx.fxml;
    exports yon.de.beesa;
}