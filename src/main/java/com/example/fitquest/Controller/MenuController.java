package com.example.fitquest.Controller;

import com.example.fitquest.Model.MyQuestsModel;
import com.example.fitquest.Model.QuestsModel;
import com.example.fitquest.Screen.NewScene;

public class MenuController {

    public void onStartChallengeClick() {
        NewScene.getInstance().loadNewScene("/com/example/fitquest/quest-view.fxml");
    }

    public void myQuestClick() {
        NewScene.getInstance().loadNewScene("/com/example/fitquest/myquest-view.fxml");
    }

    public void onLeaderboardClick() {
        NewScene.getInstance().loadNewScene("/com/example/fitquest/leaderboard-view.fxml");
    }

    public void onLogoutClick() {
        NewScene.getInstance().loadNewScene("/com/example/fitquest/login-view.fxml");
    }
}
