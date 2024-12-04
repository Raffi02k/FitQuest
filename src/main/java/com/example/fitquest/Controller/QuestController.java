package com.example.fitquest.Controller;

import com.example.fitquest.Screen.NewScene;

public class QuestController {

    public void onMenuClick(){
        NewScene.getInstance().loadNewScene("/com/example/fitquest/Menu-view.fxml");
    }
}
