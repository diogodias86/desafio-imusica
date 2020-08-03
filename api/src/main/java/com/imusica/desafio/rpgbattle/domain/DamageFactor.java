package com.imusica.desafio.rpgbattle.domain;

import com.imusica.desafio.rpgbattle.domain.enums.DiceType;

public class DamageFactor {
    private int diceNumbers;
    private DiceType diceType;

    public DamageFactor(int diceNumbers, DiceType diceType) {
        this.diceNumbers = diceNumbers;
        this.diceType = diceType;
    }

    public int getDiceNumbers() {
        return diceNumbers;
    }

    public DiceType getDiceType() {
        return diceType;
    }
}
