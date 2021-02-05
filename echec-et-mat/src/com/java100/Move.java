package com.java100;

public class Move {

    private int number;
    private Piece piece;
    private Position destinationPosition;
    private Position initialPosition;

    public Move() {
    }

    public Move(int number, Piece piece, Position destinationPosition) {
        this.number = number;
        this.piece = piece;
        this.destinationPosition = destinationPosition;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position getDestinationPosition() {
        return destinationPosition;
    }

    public void setDestinationPosition(Position destinationPosition) {
        this.destinationPosition = destinationPosition;
    }

    public Position getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(Position initialPosition) {
        this.initialPosition = initialPosition;
    }

}
