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
    }

    public static FQDatabase getInstance() {
        if (database == null) {
            database = new FQDatabase();
        }
        return database;
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
        return new ArrayList<>(quests);
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
