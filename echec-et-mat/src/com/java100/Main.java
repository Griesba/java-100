package com.java100;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Chess chess = new Chess();

        List<Move> moves = new ArrayList<>();

        //1: PEDONE 1 B a4
        moves.add(new Move(1, new Piece(PieceType.PEDONE_B, 1, Color.B), new Position(0, 3)));
        //2: PEDONE 1 N a5
        moves.add(new Move(2, new Piece(PieceType.PEDONE_N, 1, Color.N), new Position(0, 4)));
        //3: CAVALLO 1 B c3
        moves.add(new Move(3, new Piece(PieceType.CAVALLO_B, 1, Color.B), new Position(2, 2)));
        //4: PEDONE 2 N b5
        moves.add(new Move(4, new Piece(PieceType.PEDONE_N, 2, Color.N), new Position(1, 4)));
        // 5: PEDONE 8 B h4
        moves.add(new Move(5, new Piece(PieceType.PEDONE_B, 8, Color.B), new Position(7, 3)));
        //6: CAVALLO 1 N c6
        moves.add(new Move(6, new Piece(PieceType.CAVALLO_N, 1, Color.N), new Position(2, 5)));

        for (Move move: moves) {
            chess.addMove(move);
        }

        Move invalidMove = null;
        for (Move move: moves) {
            if (!chess.isValidMove(move)) {
                invalidMove = move;
                break;
            }
        }

        if (invalidMove != null) {
            System.out.println("CORRETO");
        } else {
            System.out.println("ERRORE: linea" + invalidMove.getNumber());
        }

        //System.out.println(invalidMove != null ? "CORRETO" :  "ERRORE: linea" + invalidMove.getNumber());



    }
}
