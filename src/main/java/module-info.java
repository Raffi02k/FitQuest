module com.example.fitquest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fitquest to javafx.fxml;
    exports com.example.fitquest;
    exports com.example.fitquest.screen;
    opens com.example.fitquest.screen to javafx.fxml;
    exports com.example.fitquest;
    opens com.example.fitquest to javafx.fxml;
}
