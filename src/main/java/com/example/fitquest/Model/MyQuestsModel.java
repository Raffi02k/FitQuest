package com.example.fitquest.Model;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.Data.Quest;
import com.example.fitquest.Model.Data.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class MyQuestsModel {

    private static MyQuestsModel instance;
    private final FQDatabase database = FQDatabase.getInstance();
    private final ObservableList<String> myQuestsNameObservableList = FXCollections.observableArrayList();
    private final StringProperty questDescription = new SimpleStringProperty("");
    private final StringProperty userScore = new SimpleStringProperty("");

    private MyQuestsModel() {}

    public void updateMyQuestsNameObservableList(){
        myQuestsNameObservableList.setAll(database.getCurrentUser().getChosenQuests().stream().map(Quest::getName).toList());
    }

    public void setUserScore(int score) {
        database.getCurrentUser().setScore(score);
        userScore.set("MyScore: " + database.getCurrentUser().getScore());
    }

    public void setQuestDescription(int selectedQuestIndex) {
        questDescription.set(database.getCurrentUser().getChosenQuests().get(selectedQuestIndex).getDescription());
    }

    public void resetQuestDescription() {
        questDescription.set("");
    }

    /**
     * Hanterar avslutade uppdrag, uppdaterar poängen och UI-bindningen.
     */
    public void processFinishedQuest(int selectedQuestIndex) {
        User currentUser = database.getCurrentUser();
        Quest selectedQuest = currentUser.getChosenQuests().get(selectedQuestIndex);

        if (!selectedQuest.isCompleted()) { // Kontrollera om questen redan är klar
            int scoreToAdd = selectedQuest.getScore();
            currentUser.addPointsToScore(scoreToAdd);
            userScore.set("MyScore: " + currentUser.getScore());
            selectedQuest.setCompleted(true); // Markera questen som klar
            //Lägg till detta nedanför om ni vill att questen ska försvinna när ni finishar den.
            //currentUser.removeQuest(selectedQuest);
           // userQuestsNames.remove(selectedQuestIndex);
        } else {
            // Show an alert if the quest is already completed
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Quest Already Completed");
            alert.setHeaderText(null);
            alert.setContentText("This quest has already been completed.");
            alert.showAndWait();
        }
    }

    // GETTERS

    public static synchronized MyQuestsModel getInstance() {
        if (instance == null) {
            instance = new MyQuestsModel();
        }
        return instance;
    }

    public ObservableList<String> getMyQuestsNameObservableList() {
        return myQuestsNameObservableList;
    }

    public StringProperty questDescriptionProperty() {
        return questDescription;
    }

    public StringProperty userScoreProperty() {
        return userScore;
    }
}
