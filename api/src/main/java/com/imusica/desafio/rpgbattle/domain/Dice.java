package com.imusica.desafio.rpgbattle.domain;

import com.imusica.desafio.rpgbattle.domain.enums.DiceType;

import java.util.Random;

public class Dice {

    private DiceType type;

    public Dice(DiceType type) {
        this.type = type;
    }

    public int play() {
        Random rand = new Random();
        int randomNumber = 0;

        do {
            randomNumber = rand.nextInt(this.type.totalFaces());
        } while (randomNumber == 0);

        return randomNumber;
    }

}
