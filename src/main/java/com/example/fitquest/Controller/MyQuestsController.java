package com.example.fitquest.Controller;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.MyQuestsModel;
import com.example.fitquest.Screen.NewScene;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class MyQuestsController {

    private final MyQuestsModel myQuestsModel = MyQuestsModel.getInstance();
    @FXML
    private ListView<String> myQuestsListView;
    @FXML
    private TextArea myQuestsDescriptionTextArea;
    @FXML
    private Label myQuestsUserScoreLabel;

    public void initialize() {
        myQuestsListView.setItems(myQuestsModel.getMyQuestsNameObservableList());
        myQuestsDescriptionTextArea.textProperty().bind(myQuestsModel.questDescriptionProperty());
        myQuestsUserScoreLabel.textProperty().bind(myQuestsModel.userScoreProperty());
    }

    public void myQuestsListClicked() {
        int selectedIndex = myQuestsListView.getSelectionModel().getSelectedIndex();
        myQuestsModel.setQuestDescription(selectedIndex);
    }

    public void myQuestsFinishButtonClicked() {
        int selectedIndex = myQuestsListView.getSelectionModel().getSelectedIndex();
        myQuestsModel.processFinishedQuest(selectedIndex);
    }

    public void resetButtonClicked() {
        myQuestsModel.setUserScore(0); // Uppdatera userScoreProperty istället för att direkt sätta texten på Label
    }

    public void onMenuClick(){
        NewScene.getInstance().loadNewScene("/com/example/fitquest/Menu-view.fxml");
    }

}
