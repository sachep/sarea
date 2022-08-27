module yonrupech.controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires yonrupech.start;

    opens yonrupech.controller to javafx.fxml;
    exports yonrupech.controller;
}