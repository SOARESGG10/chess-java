package br.soares.app;

import br.soares.boardgame.exceptions.BoardException;
import br.soares.chess.ChessMatch;
import br.soares.chess.ChessPiece;
import br.soares.chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            ChessMatch chessMatch = new ChessMatch();

            while (true) {
                UI.cleanScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.printf("%nSource: ");
                ChessPosition source = UI.readChessPosition(scanner);
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(scanner);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
        } catch (BoardException exception) {
            System.out.printf("%nError: %s%n", exception.getMessage());
        } catch (RuntimeException exception) {
            throw  new InputMismatchException("Error ChessPosition. Valid values are from A1 to H8");
        }
    }
}