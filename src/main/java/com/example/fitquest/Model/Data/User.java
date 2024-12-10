package com.example.fitquest.Model.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * User class.
 * Describes a user of the application.
 */
public class User {

    private static int idCounter = 1000;
    private final int id;
    private String username;
    private String password;
    private int score;
    private List<User> friends;
    private List<Quest> quests;

    public User(String username, String password) {
        id = idCounter++;
        this.username = username;
        this.password = password;
        score = 0;
        friends = new ArrayList<>();
        quests = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public boolean addFriend(User user) {
        return friends.add(user);
    }

    public boolean removeFriend(User user) {
        return friends.remove(user);
    }

    public User getFriend(int index) {
        return friends.get(index);
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

    public Quest getQuest(int index) {
        return quests.get(index);
    }

    public int getScore() {
        return score;
    }

    public void addPointsToScore(int pointsToAdd) {
        score = score + pointsToAdd;
    }

    public void reset() {
        this.score = 0;
    }
}
