package com.example.fitquest.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onStartChallengeClick() {
        System.out.println("Start Quest clicked!");
        // Här kan du byta till Start Challenge-skärmen när den är redo
        // loadNewScene("start-Quest-view.fxml");
    }

    @FXML
    protected void onLeaderboardClick() {
        System.out.println("Leaderboard clicked!");
        // Här kan du byta till Leaderboard-skärmen
        // loadNewScene("/com/example/fitquest/leaderboard-view.fxml");
    }

    @FXML
    protected void onLogoutClick() {
        // Här kan du byta tillbaka till Login-skärmen
        loadNewScene("/com/example/fitquest/login-view.fxml");
    }

    // Hjälpmetod för att byta skärm/scen.
    private void loadNewScene(String fxmlPath) {
        try {
            Stage stage = (Stage) welcomeText.getScene().getWindow(); // Hämta nuvarande fönster
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load(), 400, 800);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
