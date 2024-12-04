package com.example.fitquest.Model;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.Data.Quest;
import com.example.fitquest.Model.Data.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MyQuestsModel {

    private static MyQuestsModel instance; // Singleton-instans
    private final FQDatabase database;
    private final ObservableList<String> userQuestsNames = FXCollections.observableArrayList();
    private final StringProperty questDescription = new SimpleStringProperty("");
    private final StringProperty userScore = new SimpleStringProperty("");

    /**
     * Privat konstruktor för att säkerställa att endast en instans kan skapas.
     */
    private MyQuestsModel() {
        database = FQDatabase.getInstance();
        User currentUser = database.getCurrentUser();

        // Testkod - endast körs vid första initiering
        currentUser.addQuest(new Quest("Quest1", "MyQuest1 Description", 100));
        currentUser.addQuest(new Quest("Quest2", "MyQuest2 Description", 200));
        currentUser.addQuest(new Quest("Quest3", "MyQuest3 Description", 300));

        userQuestsNames.addAll(currentUser.getQuests().stream().map(Quest::getName).toList());
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
        int scoreToAdd = currentUser.getQuests().get(selectedQuestIndex).getScore();
        currentUser.addPointsToScore(scoreToAdd);
        userScore.set("MyScore: " + currentUser.getScore());
    }
}
