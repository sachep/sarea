module start.yon.de.demofx2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens start.yon.de.demofx2 to javafx.fxml;
    exports start.yon.de.demofx2;
}