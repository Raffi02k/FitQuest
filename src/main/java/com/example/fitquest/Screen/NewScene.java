package com.example.fitquest.Screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class NewScene {

    private static NewScene newScene;

    private NewScene() {}

    public static NewScene getInstance(){
        if(newScene == null){
            newScene = new NewScene();
        }
        return newScene;
    }

    // Hjälpmetod för att byta skärm/scen.
    public void loadNewScene(String fxmlPath) {
        try {
            Stage stage = HelloApplication.currentStage;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load(), 400, 700);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
