package com.example.fitquest.Model;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.Data.Quest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QuestsModel {

    private static QuestsModel instance;
    private final MyQuestsModel myQuestsModel = MyQuestsModel.getInstance();
    private final FQDatabase database = FQDatabase.getInstance();
    private final ObservableList<String> allQuestsNameObservableList = FXCollections.observableArrayList();

    private QuestsModel() {
        allQuestsNameObservableList.addAll(database.getQuests().stream().map(Quest::getName).toList());
    }

    public static QuestsModel getInstance() {
        if (instance == null) {
            instance = new QuestsModel();
        }
        return instance;
    }

    public ObservableList<String> getAllQuestsNameObservableList() {
        return allQuestsNameObservableList;
    }

    public void removeQuestNameFromAllQuestsNameObservableList(int selectedListIndex){
        allQuestsNameObservableList.remove(selectedListIndex);
    }

    public void addQuestToUsersQuestsList(String selectedListName) {

        // Hämta från databasen, det quest som matchar det markerade questNamnet i allQuestsNameListView - listan.
        // Addera questet till currentUser:s questLista.
        for (Quest quest : database.getQuests()) {
            if (quest.getName().equals(selectedListName)) {
                database.getCurrentUser().getQuests().add(quest);
            }
        }

        // Informera MyQuestsModel om användarens questLista har uppdaterats
        // (= uppdatera myQuestsNameObservableList i MyQuestsModel)
        myQuestsModel.refreshMyQuestsNameObservableList();
    }
}
