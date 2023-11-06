module bom.menu {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;

    opens bom.menu to javafx.fxml;
    exports bom.menu;
}