module demos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires com.jfoenix;
    requires java.sql;

    opens demos to javafx.fxml;
    exports demos;
}