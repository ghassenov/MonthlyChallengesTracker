package com.ghassenov.challengeapp.Entities;

public class Challenge {
    private long id;
    private String month;
    private String description;

    public Challenge(long id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }
    public long getId() {
        return id;
    }
    public String getMonth() {
        return month;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public void setId(long id) {
        this.id = id;
    }
}
