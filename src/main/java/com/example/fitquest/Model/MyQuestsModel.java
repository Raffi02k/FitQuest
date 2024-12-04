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

        // Fitness-relaterade quests
        currentUser.addQuest(new Quest("1.          Morning Walk", "Walk 10 km in one day", 150));
        currentUser.addQuest(new Quest("2.          Push-Up Pro", "Complete 50 push-ups in a row", 200));
        currentUser.addQuest(new Quest("3.          Yoga Master", "Do a 30-minute yoga session", 100));
        currentUser.addQuest(new Quest("4.          Hydration Hero", "Drink 3 liters of water in a day", 50));
        currentUser.addQuest(new Quest("5.          Stair Sprint", "Run up and down stairs 20 times", 120));
        currentUser.addQuest(new Quest("6.          Plank Champ", "Hold a plank for 2 minutes", 180));

        // Lägg till alla quests i ObservableList
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
