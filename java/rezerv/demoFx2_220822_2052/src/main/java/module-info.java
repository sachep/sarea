module yon.de.demofx2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens yon.de.demofx2 to javafx.fxml;
    exports yon.de.demofx2;
}