package com.imusica.desafio.rpgbattle.domain;

import com.imusica.desafio.rpgbattle.domain.enums.MonsterType;
import com.imusica.desafio.rpgbattle.factory.MonsterFactory;

import java.util.Random;

public class Battle {
    private User user;
    private Hero hero;
    private Monster opponent;

    public Battle(User user) {
        this.user = user;
        this.hero = user.getHero();
    }

    public Hero getHero() {
        return hero;
    }

    public Monster getOpponent() {
        return opponent;
    }

    public void start() {
        //Gera o oponente de forma aleatória
        this.selectOpponent();

        //1 passo - Iniciativa
        this.init();

        //2 passo - Ataque

        //Calcula o dano
    }

    private void selectOpponent() {
        int randomNum = new Random().nextInt(3);
        MonsterType randomMonsterType = MonsterType.values()[randomNum];

        this.opponent = MonsterFactory.createByType(randomMonsterType);
    }

    private void init() {

    }

}
