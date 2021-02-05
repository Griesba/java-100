package com.java100;

public class Piece {
    private PieceType pieceType;
    private int pieceNumber;
    private Color color;
    private Position currentPosition;
    private boolean isActive = true;

    public Piece() {
    }

    public Piece(PieceType pieceType, int pieceNumber, Color color) {
        this.pieceType = pieceType;
        this.pieceNumber = pieceNumber;
        this.color = color;
        this.currentPosition = new Position(pieceNumber -1, pieceType.getY0());
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public int getPieceNumber() {
        return pieceNumber;
    }

    public void setPieceNumber(int pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
