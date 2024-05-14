package boardgame;

public class Piece {
	
	protected Position position; // Variável do tipo protected para a peça receber uma posição
	private Board board; // Variável para receber o tabuleiro
	
	public Piece(Board board) { // Construtor recebendo o tabuleiro
		this.board = board;
		position = null; // Define a posição da peça como nula, sem posicionar ela no tabuleiro ainda
	}

	protected Board getBoard() { // Getter do board
		return board;
	}
	
}
