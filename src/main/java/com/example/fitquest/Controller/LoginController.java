package com.example.fitquest.Controller;

import com.example.fitquest.Model.LoginModel;
import com.example.fitquest.Screen.NewScene;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        errorLabel.textProperty().bind(loginModel.errorMessageProperty());
    }

    public void onLoginButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(loginModel.checkUserCredentials(username, password)){
            NewScene.getInstance().loadNewScene("/com/example/fitquest/menu-view.fxml");
        }
    }
}
