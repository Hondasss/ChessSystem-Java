package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece{
	
	// Subclasse ChessPiece adiciona a cor da peça e herda o board e o position, previamente declarado como nulo.
	private Color color;

	// Construtor com o argumento da cor e o board, repassando o board ao construtor da superclasse (Piece)
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	// Getter
	public Color getColor() {
		return color;
	}
	
}
