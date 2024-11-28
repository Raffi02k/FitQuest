module com.example.fitquest {
    requires javafx.controls;
    requires javafx.fxml;

    // Om detta är ditt huvudpaket
    opens com.example.fitquest to javafx.fxml;
    exports com.example.fitquest.Screen;

    // Om Screen är ett separat paket
    opens com.example.fitquest.Screen to javafx.fxml;
    exports com.example.fitquest;
}
