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
        // i så fall, byt till menu-view().
        if(loginModel.checkUserCredentials(username, password)){
            NewScene newScene = NewScene.getInstance();
            newScene.loadNewScene("/com/example/fitquest/menu-view.fxml");
        }
    }
}
