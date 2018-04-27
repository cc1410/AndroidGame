package com.example.juanelberto.menuprincipal.model;

/**
 * Created by chen on 14/02/2018.
 */

public class RankingUser {
    private User user;
    int score;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
