module yonrupech.controller {
    requires javafx.controls;
    requires javafx.fxml;

    opens yonrupech.controller to javafx.fxml;
    exports yonrupech.controller;
}