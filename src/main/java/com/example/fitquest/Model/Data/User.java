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
    private List<Quest> chosenQuests;
    private List<Quest> allAvailableQuests;

    public User(String username, String password) {
        id = idCounter++;
        this.username = username;
        this.password = password;
        score = 0;
        friends = new ArrayList<>();
        chosenQuests = new ArrayList<>();
        allAvailableQuests = FQDatabase.getInstance().getQuests();
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

    public List<Quest> getChosenQuests() {
        return chosenQuests;
    }

    public void setChosenQuests(List<Quest> chosenQuests) {
        this.chosenQuests = chosenQuests;
    }

    public void addQuestToChosenQuests(Quest quest) {
        chosenQuests.add(quest);
    }

    public boolean removeQuestFromChosenQuests(Quest quest) {
        return chosenQuests.remove(quest);
    }

    public Quest getQuest(int index) {
        return chosenQuests.get(index);
    }

    public List<Quest> getAllAvailableQuests() {
        return allAvailableQuests;
    }

    public void setAllAvailableQuests(List<Quest> allAvailableQuests) {
        this.allAvailableQuests = allAvailableQuests;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addPointsToScore(int pointsToAdd) {
        score = score + pointsToAdd;
    }
}
