package com.example.fitquest.Model;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.Data.Quest;
import com.example.fitquest.Model.Data.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.util.List;

public class MyQuestsModel {

    private static MyQuestsModel instance;
    private final FQDatabase database;
    private final ObservableList<String> userQuestsNames = FXCollections.observableArrayList();
    private final StringProperty questDescription = new SimpleStringProperty("");
    private final StringProperty userScore = new SimpleStringProperty("");


    public void setUserScore(int score) {
        this.userScore.set("MyScore: " + score);
    }

    /**
     * Privat konstruktor för att säkerställa att endast en instans kan skapas.
     */
    private MyQuestsModel() {
        database = FQDatabase.getInstance();
    }

    public void addQuest(Quest quest) {
        if (!userQuestsNames.contains(quest.getName())) {
            userQuestsNames.add(quest.getName());  // Lägg till quest namnet
            database.getCurrentUser().addQuest(quest);
            // Kanske någon refresh?
        }
    }

    /**
     * Getter för singleton-instansen. Skapar instansen om den inte redan finns.
     */
    public static synchronized MyQuestsModel getInstance() {
        if (instance == null) {
            instance = new MyQuestsModel();
        }
        return instance;
    }

    public ObservableList<String> getUserQuestsNames() {
        return userQuestsNames;
    }

    public StringProperty questDescriptionProperty() {
        return questDescription;
    }

    public void setQuestDescription(int selectedQuestIndex) {
        questDescription.set(database.getCurrentUser().getQuests().get(selectedQuestIndex).getDescription());
    }


    public StringProperty userScoreProperty() {
        return userScore;
    }

    /**
     * Hanterar avslutade uppdrag, uppdaterar poängen och UI-bindningen.
     */
    public void processFinishedQuest(int selectedQuestIndex) {
        User currentUser = database.getCurrentUser();
        Quest selectedQuest = currentUser.getQuests().get(selectedQuestIndex);

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

}
