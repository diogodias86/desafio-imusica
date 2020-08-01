package com.imusica.desafio.rpgbattle.domain;

import com.imusica.desafio.rpgbattle.domain.enums.CharacterType;

public class Hero extends Character {

    public Hero(String name, int life, int strength, int defense, int agility, String damageFactor) {
        super(name, life, strength, defense, agility, damageFactor);
    }

    @Override
    public CharacterType getType() {
        return CharacterType.HERO;
    }
}
