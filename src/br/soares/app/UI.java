package br.soares.app;

import br.soares.chess.ChessPiece;
import br.soares.chess.ChessPosition;
import br.soares.util.OsSystems;
import br.soares.util.enums.Systems;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class UI {

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
                printPiece(pieces[row][column]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-");
        } else {
            System.out.print(piece);
        }
        System.out.print(" ");
    }

}
