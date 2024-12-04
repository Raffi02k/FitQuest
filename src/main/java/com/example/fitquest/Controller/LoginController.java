package com.example.fitquest.Controller;

import com.example.fitquest.Model.LoginModel;
import com.example.fitquest.Screen.NewScene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {

    private LoginModel loginModel;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;

    public void initialize() {
        loginModel = new LoginModel();
        // Binder errorLabel till loginModel:s errorMessage vilket gör
        // att ändringar som görs på fältet errorMessage i LoginModel
        // även påverkar errorLabel (text som sätts på errorMessage i LoginModel kommer synas i errorLabel)
        errorLabel.textProperty().bind(loginModel.errorMessageProperty());
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public void onLoginButtonClick() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        // Kollar om användaren finns i databasen och om lösenordet stämmer,
        // i så fall, loadMenuScreen().
        if(loginModel.checkUserCredentials(username, password)){
            NewScene newScene = NewScene.getInstance();
            newScene.loadNewScene("/com/example/fitquest/menu-view.fxml");
            //loadMenuScreen();
        }
    }

    // Metod för att ladda meny-skärmen.
    private void loadMenuScreen() {
        try {
            // Hämta nuvarande fönster (Stage)
            Stage stage = (Stage) usernameField.getScene().getWindow();

            // Ladda menu-view.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/fitquest/menu-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 700);

            // Byt scen
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
