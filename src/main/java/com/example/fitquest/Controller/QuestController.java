package com.example.fitquest.Controller;

import com.example.fitquest.Model.MyQuestsModel;
import com.example.fitquest.Model.QuestsModel;
import com.example.fitquest.Screen.NewScene;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class QuestController {

    private QuestsModel questsModel;
    @FXML
    private ListView<String> questsList;
//    @FXML
//    private TextArea questsDescriptionTextArea;     // Endast ifall Quest beskrivning ska vara med när man klickar på en Quest i listan.

    public void onMenuClick(){
        NewScene.getInstance().loadNewScene("/com/example/fitquest/Menu-view.fxml");
    }

//    /**
//     * Metod anropas när knappen "Add to My Quests" (behöver ej vara just den texten) klickas på i Quest-view.
//     * Metoden hämtar indexet hos det markerade questet och anropar sedan metod i questModel som kommer att
//     * addera questet till användarens egna questlista.
//     */
//    public void addToMyQuestsButtonClicked(){
//        int selectedIndex = questsList.getSelectionModel().getSelectedIndex();
//        questsModel.addQuestToUserQuests(selectedIndex);
//    }

//    /**
//     * Metod anropas när användaren klickar på listan.
//     * I nuläget sätter den Quest beskrivningen till ett TextArea,
//     * men om det inte ska vara med kan vi ta bort denna metod.
//     */
//    public void questsListClicked(){
//        int selectedIndex = questsList.getSelectionModel().getSelectedIndex();
//        questsModel.setQuestDescription(selectedIndex);
//    }
}
