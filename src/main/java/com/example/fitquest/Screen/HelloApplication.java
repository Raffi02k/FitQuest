package com.example.fitquest.Screen;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.Data.Quest;
import com.example.fitquest.Model.Data.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static Stage currentStage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/fitquest/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        stage.setTitle("Login Screen");
        stage.setScene(scene);
        stage.show();
        currentStage = stage;
    }

    public static void main(String[] args) {
        FQDatabase database = FQDatabase.getInstance();

        // Lägger till några quests i databasen
        database.addQuest(new Quest("1. Morning Walk", "Walk 10 km in one day", 150));
        database.addQuest(new Quest("2. Push-Up Pro", "Complete 50 push-ups in a row", 200));
        database.addQuest(new Quest("3. Yoga Master", "Do a 30-minute yoga session", 100));
        database.addQuest(new Quest("4. Hydration Hero", "Drink 3 liters of water in a day", 50));
        database.addQuest(new Quest("5. Stair Sprint", "Run up and down stairs 20 times", 120));
        database.addQuest(new Quest("6. Plank Champ", "Hold a plank for 2 minutes", 180));

        database.addUser(new User("admin", "admin"));
        database.addUser(new User("user", "user"));
        database.addUser(new User("a", "a"));

        launch();
    }
}
