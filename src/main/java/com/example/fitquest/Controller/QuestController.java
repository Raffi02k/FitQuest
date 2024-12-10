
package com.example.fitquest.Controller;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.Data.Quest;
import com.example.fitquest.Model.MyQuestsModel;
import com.example.fitquest.Model.QuestsModel;
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

    private final FQDatabase database = FQDatabase.getInstance();
    private final MyQuestsModel myQuestsModel = MyQuestsModel.getInstance();

    @FXML
    private AnchorPane QuestGridPane;

    @FXML
    public void initialize() {
        // Lägg till alla quests from QuestModel
        questsList.getItems().addAll(
                QuestsModel.getInstance().getAllQuests().stream().map(Quest::getName).toList()
        );
        questsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
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
        int selectedIndex = questsList.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            Quest selectedQuest = QuestsModel.getInstance().getAllQuests().get(selectedIndex);

            MyQuestsModel.getInstance().addQuest(selectedQuest);
            System.out.println("Quest added to My Quests: " + selectedQuest.getName());

            // Ta bort questen när man har valt den
            QuestsModel.getInstance().getAllQuests().remove(selectedIndex);
            questsList.getItems().remove(selectedIndex);

            questsList.refresh();

            // Visa en alert att den har blivit tillagd i myquest
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Quest Added");
            alert.setHeaderText(null);
            alert.setContentText("The quest " + selectedQuest.getName() + " has been added to your quests!");
            alert.showAndWait(); // Show the alert and wait for the user to close it
        } else {
            System.out.println("No quest selected!");
        }
    }
}
