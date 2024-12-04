package com.example.fitquest.Model.Data;

/**
 * Quest class.
 * Describes a quest in the application.
 */
public class Quest {

    private static int idCounter = 1;
    private final int id;
    private String name;
    private String description;
    private int score;
    private Boolean completed = false;

    public Boolean isCompleted(){
        return completed;
    }
    public void setCompleted(Boolean completed){
        this.completed = completed;
    }


    public Quest(String name, String description, int score) {
        id = idCounter++;
        this.name = name;
        this.description = description;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
