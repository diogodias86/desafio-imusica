package com.imusica.desafio.rpgbattle.domain;

import com.imusica.desafio.rpgbattle.domain.enums.CharacterType;

public class Monster extends Character {

    public Monster(String name, int life, int strength, int defense, int agility, DamageFactor damageFactor) {
        super(name, life, strength, defense, agility, damageFactor);
    }

    @Override
    public CharacterType getType() {
        return CharacterType.MONSTER;
    }
}
