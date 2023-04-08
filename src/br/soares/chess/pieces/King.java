package br.soares.chess.pieces;

import br.soares.boardgame.Board;
import br.soares.chess.ChessPiece;
import br.soares.chess.enums.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }
}
