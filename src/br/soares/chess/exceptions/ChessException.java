package br.soares.chess.exceptions;

import br.soares.boardgame.exceptions.BoardException;

import java.io.Serial;

public class ChessException extends BoardException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ChessException(String exception) {
        super(exception);
    }
}
