package br.soares.chess;

import br.soares.boardgame.Position;
import br.soares.chess.exceptions.ChessException;

public class ChessPosition {

    private int row;
    private char column;

    public ChessPosition(int row, char column) {
        if (column < 'A' || column > 'H' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition: Valid values are from A1 to H8");
        }
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    protected Position toPosition() {
        return new Position(8 - row, column - 'A');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((8 - position.getRow()), (char) ('A' - position.getColumn()));
    }

    @Override
    public String toString() {
        return "%s%s".formatted(column, row);
    }
}
