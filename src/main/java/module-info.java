module com.example.fitquest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fitquest to javafx.fxml;
    exports com.example.fitquest;
}