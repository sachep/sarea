module yon.de.beesam {
    requires javafx.controls;
    requires javafx.fxml;


    opens yon.de.beesam to javafx.fxml;
    exports yon.de.beesam;
}