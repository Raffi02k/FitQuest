package com.example.fitquest.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    protected void onLoginButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("password")) {
            // Logga in och byt till meny-skärmen
            loadMenuScreen();
        } else {
            errorLabel.setText("Felaktigt användarnamn eller lösenord!");
        }
    }

    /**
     * Metod för att ladda meny-skärmen.
     */
    private void loadMenuScreen() {
        try {
            // Hämta nuvarande fönster (Stage)
            Stage stage = (Stage) usernameField.getScene().getWindow();

            // Ladda menu-view.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/fitquest/menu-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400,650);

            // Byt scen
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
