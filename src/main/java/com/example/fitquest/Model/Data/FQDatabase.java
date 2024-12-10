package com.example.fitquest.Model.Data;

import java.util.ArrayList;
import java.util.List;

public class FQDatabase {

    private static FQDatabase database;
    private User currentUser;
    private List<User> users;
    private List<Quest> quests;

    private FQDatabase() {
        users = new ArrayList<>();
        quests = new ArrayList<>();

        // Lägger till en user i databasen
        users.add(new User("admin", "admin"));
        users.add(new User("user", "user"));
        users.add(new User("a", "a"));


        // Lägger till några quests i databasen
        quests.add(new Quest("1. Morning Walk", "Walk 10 km in one day", 150));
        quests.add(new Quest("2. Push-Up Pro", "Complete 50 push-ups in a row", 200));
        quests.add(new Quest("3. Yoga Master", "Do a 30-minute yoga session", 100));
        quests.add(new Quest("4. Hydration Hero", "Drink 3 liters of water in a day", 50));
        quests.add(new Quest("5. Stair Sprint", "Run up and down stairs 20 times", 120));
        quests.add(new Quest("6. Plank Champ", "Hold a plank for 2 minutes", 180));
    }

    public static FQDatabase getInstance() {
        if (database == null) {
            database = new FQDatabase();
        }
        return database;
    }
    public void resetCurrentUser() {
        if (currentUser != null) {
            currentUser.reset();
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }

    public User getUser(int index){
        return users.get(index);
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public boolean addQuest(Quest quest) {
        return quests.add(quest);
    }

    public boolean removeQuest(Quest quest) {
        return quests.remove(quest);
    }

    public Quest getQuest(int index){
        return quests.get(index);
    }
}
