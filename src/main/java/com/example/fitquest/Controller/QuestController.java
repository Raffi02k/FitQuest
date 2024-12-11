
package com.example.fitquest.Controller;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.Data.Quest;
import com.example.fitquest.Model.MyQuestsModel;
import com.example.fitquest.Model.QuestsModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class QuestController {

    @FXML
    private ListView<String> questsList;
    @FXML
    private ListView<String> uniqueQuestList;

    private final FQDatabase database = FQDatabase.getInstance();
    private final MyQuestsModel myQuestsModel = MyQuestsModel.getInstance();

    @FXML
    private AnchorPane QuestGridPane;

    @FXML
    public void initialize() {
        // Populate questsList with all quests
        populateListView(questsList, QuestsModel.getInstance().getAllQuests());

        // Populate uniqueQuestList with unique quests
        populateListView(uniqueQuestList, QuestsModel.getInstance().getUniqueQuests());
    }

    private void populateListView(ListView<String> listView, ObservableList<Quest> quests) {
        listView.getItems().addAll(quests.stream().map(Quest::getName).toList());
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void onMenuClick() {
        loadNewScene("/com/example/fitquest/Menu-view.fxml");
    }

    private void loadNewScene(String fxmlPath) {
        try {
            Stage stage = (Stage) QuestGridPane.getScene().getWindow(); // Hämta nuvarande fönster
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load(), 400, 800);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addToMyQuestsButtonClicked(ActionEvent actionEvent) {
        // Handle selection from questsList
        int selectedIndex = questsList.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            Quest selectedQuest = QuestsModel.getInstance().getAllQuests().get(selectedIndex);

            MyQuestsModel.getInstance().addQuest(selectedQuest);
            System.out.println("Quest added to My Quests: " + selectedQuest.getName());

            // Remove the selected quest
            QuestsModel.getInstance().getAllQuests().remove(selectedIndex);
            questsList.getItems().remove(selectedIndex);

            questsList.refresh();

            // Show success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Quest Added");
            alert.setHeaderText(null);
            alert.setContentText("The quest " + selectedQuest.getName() + " has been added to your quests!");
            alert.showAndWait();
        } else {
            System.out.println("No quest selected in questsList!");
        }

        // Handle selection from uniqueQuestList
        int uniqueSelectedIndex = uniqueQuestList.getSelectionModel().getSelectedIndex();
        if (uniqueSelectedIndex != -1) {
            Quest selectedUniqueQuest = QuestsModel.getInstance().getUniqueQuests().get(uniqueSelectedIndex);

            MyQuestsModel.getInstance().addQuest(selectedUniqueQuest);
            System.out.println("Unique Quest added to My Quests: " + selectedUniqueQuest.getName());

            // Remove the selected unique quest
            QuestsModel.getInstance().getUniqueQuests().remove(uniqueSelectedIndex);
            uniqueQuestList.getItems().remove(uniqueSelectedIndex);

            uniqueQuestList.refresh();

            // Show success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Unique Quest Added");
            alert.setHeaderText(null);
            alert.setContentText("The unique quest " + selectedUniqueQuest.getName() + " has been added to your quests!");
            alert.showAndWait();
        } else {
            System.out.println("No quest selected in uniqueQuestList!");
        }
    }
}
