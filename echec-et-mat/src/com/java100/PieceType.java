package com.java100;

public enum PieceType {
    PEDONE_N(6),
    PEDONE_B(1),
    TORRE_N(0),
    TORRE_B(7),
    CAVALLO_B(0),
    CAVALLO_N(7),
    ALFIERE_N(7),
    ALFIERE_B(0),
    RE_N(7),
    RE_B(0),
    REGINA_B(0),
    REGINA_N(7);

    private int yo;

    PieceType(int yo) {
        this.yo = yo;
    }

    int getY0(){
        return yo;
    }
}
