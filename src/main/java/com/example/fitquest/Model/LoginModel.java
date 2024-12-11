package com.example.fitquest.Model;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.Data.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginModel {

    private StringProperty errorMessage = new SimpleStringProperty();

    public boolean checkUserCredentials(String username, String password) {

        FQDatabase database = FQDatabase.getInstance();

        for (User user : database.getUsers()) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    loadNewUser(user);
                    return true;
                } else {
                    errorMessage.set("Felaktigt lösenord.");
                    return false;
                }
            }
        }
        errorMessage.set("Felaktigt användarnamn.");
        return false;
    }

    public void loadNewUser(User user){
        FQDatabase database = FQDatabase.getInstance();
        QuestsModel questsModel = QuestsModel.getInstance();
        MyQuestsModel myQuestsModel = MyQuestsModel.getInstance();

        database.setCurrentUser(user);
        questsModel.updateUserAvailableQuestsNameObservableList();
        myQuestsModel.updateMyQuestsNameObservableList();
        myQuestsModel.resetQuestDescription();
        myQuestsModel.setUserScore(database.getCurrentUser().getScore());
    }

    public StringProperty errorMessageProperty() {
        return errorMessage;
    }
}
