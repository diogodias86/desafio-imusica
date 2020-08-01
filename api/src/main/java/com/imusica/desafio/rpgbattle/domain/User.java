package com.imusica.desafio.rpgbattle.domain;

public class User {
    private String nickname;
    private Hero hero;
    private int totalPoints = 0;

    public User(String nickname, Hero hero) {
        this.nickname = nickname;
        this.hero = hero;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
