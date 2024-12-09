package com.example.fitquest.Controller;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.MyQuestsModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MyQuestsController {


    private MyQuestsModel myQuestsModel;
    @FXML
    private ListView<String> myQuestsList;
    @FXML
    private TextArea myQuestsDescriptionTextArea;
    @FXML
    private Label myQuestsUserScore;

    @FXML
    private VBox MyQuestGridPane;

    @FXML
    public void onMenuClick(){
        loadNewScene("/com/example/fitquest/Menu-view.fxml");

    }

    private void loadNewScene(String fxmlPath) {
        try {
            Stage stage = (Stage) MyQuestGridPane.getScene().getWindow(); // Hämta nuvarande fönster
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load(), 400, 800);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initierar instans till myQuestsModel.
     * Sätter ListView att visa alla användarens quests namn.
     * Binder TextArea till myQuestsModel StringProperty questDescription (om questDescription ändras så gör även myQuestsDescriptionTextArea det)
     */
    public void initialize() {
        myQuestsModel = MyQuestsModel.getInstance(); // Hämta singleton-instansen
        myQuestsList.getItems().addAll(myQuestsModel.getUserQuestsNames());
        myQuestsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // Försök sätta denna i FXML:en
        myQuestsDescriptionTextArea.textProperty().bind(myQuestsModel.questDescriptionProperty());
        myQuestsUserScore.textProperty().bind(myQuestsModel.userScoreProperty());
    }


    /**
     * Triggas när användaren klickar på någon av questen i listan.
     * Hämtar den markerade questens index i listan.
     * Skickar det indexet vidare till myQuestModel:s metod setQuestDescription(int),
     * som hämtar det valda questets beskrivning och sätter det till en StringProperty som är bunden till TextArea i denna klass.
     */
    public void myQuestsListClicked() {
        int selectedIndex = myQuestsList.getSelectionModel().getSelectedIndex();
        myQuestsModel.setQuestDescription(selectedIndex);
    }

    public void myQuestsFinishButtonClicked() {
        int selectedIndex = myQuestsList.getSelectionModel().getSelectedIndex();
        myQuestsModel.processFinishedQuest(selectedIndex);
    }
    @FXML
    public void resetButtonClicked() {
        FQDatabase.getInstance().resetCurrentUser();
        myQuestsModel.setUserScore(0); // Uppdatera userScoreProperty istället för att direkt sätta texten på Label
    }
}
