package br.soares.app;

import br.soares.chess.ChessPiece;
import br.soares.chess.ChessPosition;
import br.soares.chess.enums.Color;
import br.soares.util.OsSystems;
import br.soares.util.enums.Systems;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class UI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN_BACKGROUND = "\033[42m";

    public static void cleanScreen() {
        try {
            String command;
            Systems osSystem = OsSystems.getOperatingSystem();

            if (Objects.requireNonNull(osSystem) == Systems.WINDOWS) {
                command = "cls";
            } else {
                command = "clear";
            }

            new ProcessBuilder(command).inheritIO().start().waitFor();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public static ChessPosition readChessPosition(Scanner scanner) {
        try {
            String position = scanner.nextLine();
            char column = position.charAt(0);
            int row = Integer.parseInt(position.substring(1));
            return new ChessPosition(row, column);
        } catch (RuntimeException exception) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from A1 to H8.");
        }
    }

    public static void printBoard(ChessPiece[][] pieces) {
        for (int row = 0; row < pieces.length; row++) {
            System.out.print((8 - row) + " ");
            for (int column = 0; column < pieces.length; column++) {
                printPiece(pieces[row][column], false);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int row = 0; row < pieces.length; row++) {
            System.out.print((8 - row) + " ");
            for (int column = 0; column < pieces.length; column++) {
                printPiece(pieces[row][column], possibleMoves[row][column]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }
    private static void printPiece(ChessPiece piece, boolean background) {
        if(background) {
            System.out.print(ANSI_GREEN_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        } else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_CYAN + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

}
