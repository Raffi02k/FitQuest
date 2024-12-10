package com.example.fitquest.Model;

import com.example.fitquest.Model.Data.Quest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QuestsModel {

    private static QuestsModel instance;
    private final ObservableList<Quest> allQuests = FXCollections.observableArrayList();

    /**
     * Private constructor to initialize the list of quests.
     */
    private QuestsModel() {
        allQuests.add(new Quest("1. Morning Walk", "Walk 10 km in one day", 150));
        allQuests.add(new Quest("2. Push-Up Pro", "Complete 50 push-ups in a row", 200));
        allQuests.add(new Quest("3. Yoga Master", "Do a 30-minute yoga session", 100));
        allQuests.add(new Quest("4. Hydration Hero", "Drink 3 liters of water in a day", 50));
        allQuests.add(new Quest("5. Stair Sprint", "Run up and down stairs 20 times", 120));
        allQuests.add(new Quest("6. Plank Champ", "Hold a plank for 2 minutes", 180));
    }

    /**
     * Singleton instance.
     */
    public static synchronized QuestsModel getInstance() {
        if (instance == null) {
            instance = new QuestsModel();
        }
        return instance;
    }

    /**
     * Getter for all available quests.
     */
    public ObservableList<Quest> getAllQuests() {
        return allQuests;
    }
}
