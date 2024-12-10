package com.example.fitquest.Controller;

import com.example.fitquest.Model.QuestsModel;
import com.example.fitquest.Screen.NewScene;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

public class QuestController {

    private final QuestsModel questsModel = QuestsModel.getInstance();
    @FXML
    private ListView<String> allQuestsNameListView;

    public void initialize() {
        allQuestsNameListView.setItems(questsModel.getAllQuestsNameObservableList());
    }

    public void addToMyQuestsButtonClicked() {

        int selectedListIndex = allQuestsNameListView.getSelectionModel().getSelectedIndex();
        String selectedListName = allQuestsNameListView.getSelectionModel().getSelectedItem();

        if (selectedListIndex != -1) {
            // Låt modellen addera questen till användarens questLista och uppdatera MyQuestsModel.
            questsModel.addQuestToUsersQuestsList(selectedListName);

            // Låt modellen radera quest namnet från sin allQuestsNameObservableList
            // (ska då automatiskt uppdatera allQuestsNameListView i denna klass som styr vad som visas för användaren)
            questsModel.removeQuestNameFromAllQuestsNameObservableList(selectedListIndex);

//            allQuestsNameListView.refresh();

            // Visa en alert att den har blivit tillagd i myquest
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Quest Added");
            alert.setHeaderText(null);
            alert.setContentText("The quest " + selectedListName + " has been added to your quests!");
            alert.showAndWait(); // Show the alert and wait for the user to close it
        } else {
            System.out.println("No quest selected!");
        }
    }

    public void onMenuClick() {
        NewScene.getInstance().loadNewScene("/com/example/fitquest/Menu-view.fxml");
    }
}
