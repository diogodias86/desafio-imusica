package com.imusica.desafio.rpgbattle.factory;

import com.imusica.desafio.rpgbattle.domain.Monster;
import com.imusica.desafio.rpgbattle.domain.enums.MonsterType;

public class MonsterFactory {

    public static Monster createByType(MonsterType type) {
        switch (type) {
            case ZUMBI: return new Monster("Morto-Vivo", 25, 4, 0, 1, "2d4");
            case ORC: return new Monster("Orc", 20, 6, 2, 2, "1d8");
            case KOBOLD: return new Monster("Kobold", 20, 4, 2, 4, "3d2");
            default: throw new RuntimeException("Invalid Monster Type.");
        }
    }
}
