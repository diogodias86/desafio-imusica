package com.imusica.desafio.rpgbattle.domain.enums;

public enum DiceType {
    FACE_2(2),
    FACE_4(4),
    FACE_6(6),
    FACE_8(8),
    FACE_10(10);

    private int totalFaces;

    DiceType(int totalFaces) {
        this.totalFaces = totalFaces;
    }

    public int totalFaces() {
        return this.totalFaces;
    }
}