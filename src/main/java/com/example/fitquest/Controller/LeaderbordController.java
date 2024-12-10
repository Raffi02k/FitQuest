package com.example.fitquest.Controller;

import com.example.fitquest.Screen.NewScene;

public class LeaderbordController {

    public void onMenuClick(){
        NewScene.getInstance().loadNewScene("/com/example/fitquest/Menu-view.fxml");
    }
}
