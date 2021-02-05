package com.java100;

public class Chess {
    private Piece[][] pieces;

    public Chess() {
        this.pieces = new Piece[8][8];;
    }

    public boolean isValidMove(Move move) {
        switch (move.getPiece().getPieceType()) {
            case PEDONE_B:

                if (pieces[move.getDestinationPosition().getX()][move.getDestinationPosition().getY()] == null) {
                    if (move.getPiece().getCurrentPosition().getY() == 1 && move.getDestinationPosition().getY() == 3) {
                        movePiece(move);
                        return true;
                    }
                    if (move.getDestinationPosition().getY() == (move.getPiece().getCurrentPosition().getY() + 1)) {
                        movePiece(move);
                        return true;
                    }
                } else {
                    //cas 1: borders

                    if (move.getPiece().getCurrentPosition().getY() != 7  && (move.getPiece().getCurrentPosition().getX() == 0 || move.getPiece().getCurrentPosition().getX() == 7)) {
                        if( (move.getPiece().getCurrentPosition().getX() + 1) == move.getDestinationPosition().getX()
                                && (move.getPiece().getCurrentPosition().getY() + 1) == move.getDestinationPosition().getY()){

                            pieces[move.getDestinationPosition().getX()][move.getDestinationPosition().getY()].setActive(false);
                            movePiece(move);
                            return true;
                        }
                    } else {  //cas2: no borders
                        if( ((move.getPiece().getCurrentPosition().getX() + 1) == move.getDestinationPosition().getX()
                                && (move.getPiece().getCurrentPosition().getY() + 1) == move.getDestinationPosition().getY()) ||
                                ((move.getPiece().getCurrentPosition().getX() - 1) == move.getDestinationPosition().getX()
                                        && (move.getPiece().getCurrentPosition().getY() - 1) == move.getDestinationPosition().getY()
                                )){

                            pieces[move.getDestinationPosition().getX()][move.getDestinationPosition().getY()].setActive(false);
                            movePiece(move);
                            return true;
                        }
                    }

                }
                break;
            case PEDONE_N:
                if (pieces[move.getDestinationPosition().getX()][move.getDestinationPosition().getY()] == null) {
                    if (move.getPiece().getCurrentPosition().getY() == 6 && move.getDestinationPosition().getY() == (move.getPiece().getCurrentPosition().getY() - 2)) {
                        movePiece(move);
                        return true;
                    }
                    if (move.getDestinationPosition().getY() == (move.getPiece().getCurrentPosition().getY() - 1)) {
                        movePiece(move);
                        return true;
                    }
                } else if( (move.getPiece().getCurrentPosition().getX() + 1) == move.getDestinationPosition().getX()
                        && (move.getPiece().getCurrentPosition().getY() + 1) == move.getDestinationPosition().getY()){

                    pieces[move.getDestinationPosition().getX()][move.getDestinationPosition().getY()].setActive(false);
                    movePiece(move);
                    return true;
                }
                break;
        }
        return false;
    }

    private void movePiece(Move move) {
        move.getPiece().getCurrentPosition().setX(move.getDestinationPosition().getX());
        move.getPiece().getCurrentPosition().setY(move.getDestinationPosition().getY());
    }

    public void addMove(Move move) {
        pieces[move.getPiece().getCurrentPosition().getX()][move.getPiece().getCurrentPosition().getY()] = move.getPiece();
    }
}
