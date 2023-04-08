package br.soares.chess;

import br.soares.boardgame.Board;
import br.soares.boardgame.Piece;
import br.soares.boardgame.Position;
import br.soares.chess.enums.Color;
import br.soares.chess.exceptions.ChessException;
import br.soares.chess.pieces.King;
import br.soares.chess.pieces.Rook;

public class ChessMatch {
    private Board board;
    private static final int ROWS = 8;
    private static final int COLUMNS = 8;

    public ChessMatch() {
        board = new Board(ROWS, COLUMNS);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int row = 0; row < board.getRows(); row++) {
            for (int column = 0; column < board.getColumns(); column++) {
                mat[row][column] = (ChessPiece) board.piece(row, column);
            }
        }
        return mat;
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPosition = makeMove(source, target);

        return (ChessPiece) capturedPosition;
    }
    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(row, column).toPosition());
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }
    private void validateSourcePosition(Position position) {
        if(!board.thereAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
    }
    private void initialSetup() {
        placeNewPiece('A', 8, new Rook(board, Color.BLACK));
        placeNewPiece('B', 8, new Rook(board, Color.BLACK));
        placeNewPiece('C', 8, new Rook(board, Color.BLACK));
        placeNewPiece('D', 8, new Rook(board, Color.BLACK));
        placeNewPiece('E', 8, new Rook(board, Color.BLACK));
        placeNewPiece('F', 8, new Rook(board, Color.BLACK));
        placeNewPiece('G', 8, new Rook(board, Color.BLACK));
        placeNewPiece('H', 8, new Rook(board, Color.BLACK));

        placeNewPiece('A', 7, new Rook(board, Color.BLACK));
        placeNewPiece('B', 7, new Rook(board, Color.BLACK));
        placeNewPiece('C', 7, new Rook(board, Color.BLACK));
        placeNewPiece('D', 7, new Rook(board, Color.BLACK));
        placeNewPiece('E', 7, new Rook(board, Color.BLACK));
        placeNewPiece('F', 7, new Rook(board, Color.BLACK));
        placeNewPiece('G', 7, new Rook(board, Color.BLACK));
        placeNewPiece('H', 7, new Rook(board, Color.BLACK));

        placeNewPiece('A', 1, new Rook(board, Color.WHITE));
        placeNewPiece('B', 1, new Rook(board, Color.WHITE));
        placeNewPiece('C', 1, new Rook(board, Color.WHITE));
        placeNewPiece('D', 1, new Rook(board, Color.WHITE));
        placeNewPiece('E', 1, new Rook(board, Color.WHITE));
        placeNewPiece('F', 1, new Rook(board, Color.WHITE));
        placeNewPiece('G', 1, new Rook(board, Color.WHITE));
        placeNewPiece('H', 1, new Rook(board, Color.WHITE));

        placeNewPiece('A', 2, new Rook(board, Color.WHITE));
        placeNewPiece('B', 2, new Rook(board, Color.WHITE));
        placeNewPiece('C', 2, new Rook(board, Color.WHITE));
        placeNewPiece('D', 2, new Rook(board, Color.WHITE));
        placeNewPiece('E', 2, new Rook(board, Color.WHITE));
        placeNewPiece('F', 2, new Rook(board, Color.WHITE));
        placeNewPiece('G', 2, new Rook(board, Color.WHITE));
        placeNewPiece('H', 2, new Rook(board, Color.WHITE));

    }

}
