package com.imusica.desafio.rpgbattle.controller.dto;

import com.imusica.desafio.rpgbattle.controller.validation.EnumValidator;
import com.imusica.desafio.rpgbattle.domain.Battle;
import com.imusica.desafio.rpgbattle.domain.Hero;
import com.imusica.desafio.rpgbattle.domain.User;
import com.imusica.desafio.rpgbattle.domain.enums.HeroType;
import com.imusica.desafio.rpgbattle.factory.HeroFactory;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BattleDTO {

    @NotNull(message = "Not be null")
    @NotEmpty(message = "Not be empty")
    private String nickname;

    @NotNull(message = "Not be null")
    @NotEmpty(message = "Not be empty")
    @EnumValidator(enumClazz = HeroType.class, message = "Invalid Hero Type. Available types: [WARRIOR, BARBARIAN, PALADIN]")
    private String herotype;

    public BattleDTO(String nickname, String herotype) {
        this.nickname = nickname;
        this.herotype = herotype;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setHerotype(String herotype) {
        this.herotype = herotype;
    }

    public String getNickname() {
        return nickname;
    }
    public String getHerotype() {
        return herotype;
    }

    public Battle newBattle() {
        Hero hero = HeroFactory.createByType(this.getHerotype().toUpperCase());
        User user = new User(this.getNickname(), hero);

        return new Battle(user);
    }

}
