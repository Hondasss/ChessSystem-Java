package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition() {
	}

	public ChessPosition(char column, int row) { // Construtor que recebe a quantidade de colunas e linhas e compara com o valor UNICODE dos caracteres que representam a posição no xadrez.
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are rom a1 to h8");
		}
		this.column = column;
		this.row = row;
	}
	
	// Getters
	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	protected Position toPosition() { // Método que conververte a posição do xadrez (B3, A5, C4) para a posição normal.
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) { // Método que converte da posição normal para posição do xadrez.
		return new ChessPosition((char)('a' - position.getColumn()), position.getRow() + 8);
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
