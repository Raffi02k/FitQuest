package com.example.fitquest.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;

public class LoginController {
    public AnchorPane LoginGridPane;
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private ImageView backgroundImage;

    @FXML
    public void initialize() {
        // Ladda bakgrundsbilden från resources
        Image image = new Image(getClass().getResource("/com/example/fitquest/images/bg2.jpg").toExternalForm());
        backgroundImage.setImage(image);  // Sätt bilden i ImageView

        // Applicera GaussianBlur-effekten på bakgrunden
        GaussianBlur blur = new GaussianBlur();
        blur.setRadius(3.0);  // Justera suddigheten
        backgroundImage.setEffect(blur);  // Applicera effekten på bakgrunden
    }

    @FXML
    protected void onLoginButtonClick() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        // SELECT * FROM USERS WHERE username = username AND password = password

        /*
        ID      USERNAME        PASSWORD
        1       DEMO1           DEMO123
        2       DEMO2           DEMO3123213
         */

        if (username.equals("admin") && password.equals("password")) {
            // Logga in och byt till meny-skärmen
            loadMenuScreen();
        } else {
            errorLabel.setText("Felaktigt användarnamn eller lösenord!");
        }
    }

    // Metod för att ladda meny-skärmen.
    private void loadMenuScreen() {
        try {
            // Hämta nuvarande fönster (Stage)
            Stage stage = (Stage) usernameField.getScene().getWindow();

            // Ladda menu-view.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/fitquest/menu-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 650);

            // Byt scen
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
