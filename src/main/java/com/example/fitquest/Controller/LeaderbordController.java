package com.example.fitquest.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LeaderbordController {

    @FXML
    private VBox LeaderboardGridPane;

    @FXML
    public void onMenuClick(){
        loadNewScene("/com/example/fitquest/Menu-view.fxml");

    }
    private void loadNewScene(String fxmlPath) {
        try {
            Stage stage = (Stage) LeaderboardGridPane.getScene().getWindow(); // Hämta nuvarande fönster
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load(), 400, 800);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
