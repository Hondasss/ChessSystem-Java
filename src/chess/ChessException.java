package chess;

import boardgame.BoardException;

public class ChessException extends BoardException{ // Aborda toda exceção "BoardException"

	private static final long serialVersionUID = 1L;
	
	public ChessException(String msg) {
		super(msg);
	}

}
