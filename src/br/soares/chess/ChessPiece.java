package br.soares.chess;

import br.soares.boardgame.Board;
import br.soares.boardgame.Piece;
import br.soares.boardgame.Position;
import br.soares.chess.enums.Color;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

}
