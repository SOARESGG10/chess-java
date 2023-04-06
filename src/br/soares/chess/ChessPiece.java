package br.soares.chess;

import br.soares.boardgame.Board;
import br.soares.boardgame.Piece;
import br.soares.chess.enums.Color;

public class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
