module com.example.covua1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.covua1 to javafx.fxml;
    exports com.example.covua1;
}