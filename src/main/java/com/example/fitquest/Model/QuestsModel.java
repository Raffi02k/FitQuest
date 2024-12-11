package com.example.fitquest.Model;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.Data.Quest;
import com.example.fitquest.Model.Data.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QuestsModel {

    private static QuestsModel instance;
    private final FQDatabase database = FQDatabase.getInstance();
    private final ObservableList<String> userAvailableQuestsNameObservableList = FXCollections.observableArrayList();

    private QuestsModel() {}

    // METHODS

    public void removeQuestFromUsersAvailableQuestsList(int selectedListIndex){
        database.getCurrentUser().getAllAvailableQuests().remove(selectedListIndex);
    }

    public void addQuestToUsersChosenQuestsList(int selectedListIndex) {
        User currentUser = database.getCurrentUser();
        Quest selectedQuest = currentUser.getAllAvailableQuests().get(selectedListIndex);
        currentUser.addQuestToChosenQuests(selectedQuest);
        MyQuestsModel.getInstance().updateMyQuestsNameObservableList();
    }

    public void updateUserAvailableQuestsNameObservableList(){
        userAvailableQuestsNameObservableList.setAll(database.getCurrentUser().getAllAvailableQuests().stream().map(Quest::getName).toList());
    }

    // GETTERS

    public static QuestsModel getInstance() {
        if (instance == null) {
            instance = new QuestsModel();
        }
        return instance;
    }

    public ObservableList<String> getUserAvailableQuestsNameObservableList() {
        return userAvailableQuestsNameObservableList;
    }

}
