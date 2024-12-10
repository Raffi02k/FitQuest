package com.example.fitquest.Controller;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.MyQuestsModel;
import com.example.fitquest.Screen.NewScene;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class MyQuestsController {

    private MyQuestsModel myQuestsModel;
    @FXML
    private ListView<String> myQuestsList;
    @FXML
    private TextArea myQuestsDescriptionTextArea;
    @FXML
    private Label myQuestsUserScore;

    public void initialize() {
        myQuestsModel = MyQuestsModel.getInstance(); // Hämta singleton-instansen
        myQuestsList.getItems().addAll(myQuestsModel.getMyQuestsNameObservableList());
        myQuestsDescriptionTextArea.textProperty().bind(myQuestsModel.questDescriptionProperty());
        myQuestsUserScore.textProperty().bind(myQuestsModel.userScoreProperty());
    }

    public void myQuestsListClicked() {
        int selectedIndex = myQuestsList.getSelectionModel().getSelectedIndex();
        myQuestsModel.setQuestDescription(selectedIndex);
    }

    public void myQuestsFinishButtonClicked() {
        int selectedIndex = myQuestsList.getSelectionModel().getSelectedIndex();
        myQuestsModel.processFinishedQuest(selectedIndex);
    }

    public void resetButtonClicked() {
        FQDatabase.getInstance().resetCurrentUser();
        myQuestsModel.setUserScore(0); // Uppdatera userScoreProperty istället för att direkt sätta texten på Label
    }

    public void onMenuClick(){
        NewScene.getInstance().loadNewScene("/com/example/fitquest/Menu-view.fxml");
    }

}
