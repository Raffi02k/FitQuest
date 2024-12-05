package com.example.fitquest.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class QuestController {
    public ListView uniqueQuestsList;
    public ListView questsList;
    @FXML
    private AnchorPane QuestGridPane;

    @FXML
    public void onMenuClick() {
        loadNewScene("/com/example/fitquest/Menu-view.fxml");

    }

    private void loadNewScene(String fxmlPath) {
        try {
            Stage stage = (Stage) QuestGridPane.getScene().getWindow(); // Hämta nuvarande fönster
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load(), 400, 800);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToMyQuestsButtonClicked(ActionEvent actionEvent) {
    }
}
