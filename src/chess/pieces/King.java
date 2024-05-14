package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	// Construtor da peça REI que herda da ChessPiece.
	public King(Board board, Color color) {
		super(board, color);
	}
	
	public String toString() {
		return "K";
	}

}
