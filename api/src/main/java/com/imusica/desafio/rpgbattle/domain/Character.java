package com.imusica.desafio.rpgbattle.domain;

import com.imusica.desafio.rpgbattle.domain.enums.CharacterType;

public abstract class Character {
    private String name;
    private int life;
    private int strength;
    private int defense;
    private int agility;
    private DamageFactor damageFactor;

    public Character(String name, int life, int strength, int defense,
                     int agility, DamageFactor damageFactor) {
        this.name = name;
        this.life = life;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.damageFactor = damageFactor;
    }

    public abstract CharacterType getType();

    public Character() {
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getAgility() {
        return agility;
    }

    public DamageFactor getDamageFactor() {
        return damageFactor;
    }

    public boolean isDied() {
        return this.life <= 0;
    }

    public void sufferDamage(int damage) {
        this.life -= damage;
    }

    public boolean attack(int diceValue, Character opponent) {
        int myAttack = diceValue + this.getAgility() + this.getStrength();
        int opponentDefense = diceValue + opponent.getAgility() + opponent.getDefense();

        return (myAttack > opponentDefense);
    }
}
