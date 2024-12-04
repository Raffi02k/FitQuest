package com.example.fitquest.Controller;

import com.example.fitquest.Model.MyQuestsModel;
import com.example.fitquest.Screen.NewScene;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MyQuestsController {

    private MyQuestsModel myQuestsModel;
    @FXML
    private ListView<String> myQuestsList;
    @FXML
    private TextArea myQuestsDescriptionTextArea;
    @FXML
    private Label myQuestsUserScore;

    /**
     * Initierar instans till myQuestsModel.
     * Sätter ListView att visa alla användarens quests namn.
     * Binder TextArea till myQuestsModel StringProperty questDescription (om questDescription ändras så gör även myQuestsDescriptionTextArea det)
     */
    public void initialize() {
        myQuestsModel = new MyQuestsModel();
        myQuestsList.getItems().addAll(myQuestsModel.getUserQuestsNames());
        myQuestsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // Försök sätta denna i FXML:en (att man endast kan markera 1 quest i listan)
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

    public void onMenuClick(){
        NewScene.getInstance().loadNewScene("/com/example/fitquest/Menu-view.fxml");
    }
}
