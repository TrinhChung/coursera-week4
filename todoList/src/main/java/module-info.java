module sample.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires com.jfoenix;
    requires java.sql;

    opens sample.todolist to javafx.fxml;
    exports sample.todolist;
}