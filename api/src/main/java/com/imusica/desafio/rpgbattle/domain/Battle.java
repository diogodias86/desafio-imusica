package com.imusica.desafio.rpgbattle.domain;

import com.imusica.desafio.rpgbattle.domain.enums.DiceType;
import com.imusica.desafio.rpgbattle.domain.enums.MonsterType;
import com.imusica.desafio.rpgbattle.factory.MonsterFactory;

import java.util.Random;

public class Battle {
    private User user;
    private Hero hero;
    private Monster monster;
    private int totalTurns;
    private Dice dice10;

    //Guarda o ganhador do passo
    private Character charStepWinner;

    //Guarda o perdedor do passo
    private Character charStepLoser;

    public Battle(User user) {
        this.user = user;
        this.hero = user.getHero();
        this.totalTurns = 0;
        this.dice10 = new Dice(DiceType.FACE_10);
    }

    public BattleResult start() {
        //Gera o oponente de forma aleatória
        this.selectOpponent();

        boolean battleIsOver = false;

        while (!battleIsOver) {
            this.totalTurns++;

            //1 passo - Iniciativa
            this.init();

            //2 passo - Ataque
            boolean successfulAttack = this.makeAttack();

            if (successfulAttack) {
                //Calcula o dano
                this.calcDamage();

                battleIsOver = this.hero.isDied() || this.monster.isDied();
            }
        }

        if (this.monster.isDied()) this.updateRanking();

        return new BattleResult(this.hero, this.monster, totalTurns);
    }

    private void updateRanking() {
        user.setTotalPoints(100 - this.totalTurns);
        Ranking.getInstance().add(user);
    }

    private void calcDamage() {
        DamageFactor damageFactor = this.charStepWinner.getDamageFactor();
        int totalDamage = this.charStepWinner.getStrength();

        Dice damageDice = new Dice(damageFactor.getDiceType());

        for (int i = 1; i <= damageFactor.getDiceNumbers(); i++) {
            totalDamage += damageDice.play();
        }

        this.charStepLoser.sufferDamage(totalDamage);
    }

    private boolean makeAttack() {
        if (!this.charStepWinner.attack(this.dice10.play(), this.charStepLoser)) {
            Character charTemp = this.charStepLoser;

            this.charStepLoser = this.charStepWinner;
            this.charStepWinner = charTemp;

            return false;
        }

        return true;
    }

    private void selectOpponent() {
        int randomNum = new Random().nextInt(3);
        MonsterType randomMonsterType = MonsterType.values()[randomNum];

        this.monster = MonsterFactory.createByType(randomMonsterType);
    }

    private void init() {
        boolean hasResult = false;
        int heroAgility = 0;
        int monsterAgility = 0;

        while (!hasResult) {
            heroAgility = dice10.play() + this.hero.getAgility();
            monsterAgility = dice10.play() + this.monster.getAgility();

            hasResult = heroAgility != monsterAgility;
        }

        if (heroAgility > monsterAgility) {
            charStepWinner = this.hero;
            charStepLoser = this.monster;
        } else {
            charStepWinner = this.monster;
            charStepLoser = this.hero;
        }
    }
}
