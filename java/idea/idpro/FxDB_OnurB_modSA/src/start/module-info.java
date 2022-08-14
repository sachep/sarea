module yonrupech.start {
    requires javafx.controls;
    requires javafx.fxml;

    opens yonrupech.start to javafx.fxml;
    exports yonrupech.start;
}