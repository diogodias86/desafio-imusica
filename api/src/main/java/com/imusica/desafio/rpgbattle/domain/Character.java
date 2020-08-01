package com.imusica.desafio.rpgbattle.domain;

import com.imusica.desafio.rpgbattle.domain.enums.CharacterType;

public abstract class Character {
    private String name;
    private int life;
    private int strength;
    private int defense;
    private int agility;
    private String damageFactor;

    public Character(String name, int life, int strength, int defense,
                     int agility, String damageFactor) {
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

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public String getDamageFactor() {
        return damageFactor;
    }

    public void setDamageFactor(String damageFactor) {
        this.damageFactor = damageFactor;
    }
}
