package br.soares.chess.pieces;

import br.soares.boardgame.Board;
import br.soares.boardgame.Position;
import br.soares.chess.ChessPiece;
import br.soares.chess.enums.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "♔";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        // North (Above)
        p.setValues(position.getRow() - 1, position.getColumn());

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Northeast (Right diagonal up)

        p.setValues(position.getRow() - 1, position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // East (Right)

        p.setValues(position.getRow(), position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Southeast (Right diagonal down)

        p.setValues(position.getRow() + 1, position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // South (Below)

        p.setValues(position.getRow() + 1 , position.getColumn());

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // South-west (Left diagonal down)

        p.setValues(position.getRow() + 1 , position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // West (Left)

        p.setValues(position.getRow(), position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Northwest (Left diagonal up)

        p.setValues(position.getRow() - 1, position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }
}
