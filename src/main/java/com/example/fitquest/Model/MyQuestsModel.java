package com.example.fitquest.Model;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.Data.Quest;
import com.example.fitquest.Model.Data.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MyQuestsModel {

    private FQDatabase database;
    private ObservableList<String> userQuestsNames = FXCollections.observableArrayList();
    private StringProperty questDescription = new SimpleStringProperty("");
    private StringProperty userScore = new SimpleStringProperty("");

    /**
     * Initierar instansen till database.
     * Hämtar nuvarande användare samt dennes quests och lägger till dem i en ObservableList,
     * vilken är bunden till en ListView i MyQuestsController (ändringar som görs i denna ObservableList ska synas i ListView).
     */
    public MyQuestsModel() {
        database = FQDatabase.getInstance();
        User currentUser = database.getCurrentUser();

        // dessa 3 rader endast testkod för att se om myQuestsList fungerar
        currentUser.addQuest(new Quest("MyQuest1", "MyQuest1 Description", 100));
        currentUser.addQuest(new Quest("MyQuest2", "MyQuest2 Description", 200));
        currentUser.addQuest(new Quest("MyQuest3", "MyQuest3 Description", 300));


        userQuestsNames.addAll(currentUser.getQuests().stream().map(Quest::getName).toList());
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

    public void processFinishedQuest(int selectedQuestIndex) {
        User currentUser = database.getCurrentUser();
        int scoreToAdd = currentUser.getQuests().get(selectedQuestIndex).getScore();
        currentUser.addPointsToScore(scoreToAdd);
        userScore.set("MyScore: " + currentUser.getScore());
    }
}
