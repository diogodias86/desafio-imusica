package com.imusica.desafio.rpgbattle.factory;

import com.imusica.desafio.rpgbattle.domain.Hero;
import com.imusica.desafio.rpgbattle.domain.enums.HeroType;

public class HeroFactory {

    public static Hero createByType(String stringType) {
        try {
            HeroType type = HeroType.valueOf(stringType);

            switch (type) {
                case WARRIOR: return new Hero("Guerreiro", 12, 4, 3, 3, "2d4");
                case BARBARIAN: return new Hero("Bárbaro", 13, 6, 1, 3, "2d6");
                case PALADIN: return new Hero("Paladino", 15, 2, 5, 1, "2d4");
                default: throw new RuntimeException("Invalid type.");
            }
        } catch (Exception ex) {
            throw new RuntimeException("Invalid Hero Type. Available types: [WARRIOR, BARBARIAN, PALADIN]");
        }
    }
}
