package com.imusica.desafio.rpgbattle.domain;

import java.util.HashMap;

public class BattleResult {
    private Character hero;
    private Character monster;
    private int totalTurns;

    public BattleResult(Hero hero, Monster monster, int totalTurns) {
        this.hero = hero;
        this.monster = monster;
        this.totalTurns = totalTurns;
    }

    public Character getWinner() {
        return this.hero.isDied() ? this.monster : this.hero;
    }

    public Character getLoser() {
        return this.hero.isDied() ? this.hero : this.monster;
    }

    public int getTotalTurns() {
        return totalTurns;
    }

    public HashMap<String, Integer> getRanking() {
        return Ranking.getInstance().get();
    }
}
