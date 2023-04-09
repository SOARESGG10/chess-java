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

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);

        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
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
        if(!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }


        if(!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is not possible moves for the chosen piece");
        }
    }

    private void validateTargetPosition(Position positionSource, Position positionTarget) {
        if(!board.piece(positionSource).possibleMove(positionTarget)) {
            throw new ChessException("The chosen piece can't move to target position");
        }
    }
    private void initialSetup() {
        placeNewPiece('A', 8, new Rook(board, Color.BLACK));
        placeNewPiece('E', 8, new King(board, Color.BLACK));
        placeNewPiece('H', 8, new Rook(board, Color.BLACK));

        placeNewPiece('D', 1, new Rook(board, Color.WHITE));
        placeNewPiece('E', 1, new King(board, Color.WHITE));
        placeNewPiece('F', 1, new Rook(board, Color.WHITE));

    }

}
