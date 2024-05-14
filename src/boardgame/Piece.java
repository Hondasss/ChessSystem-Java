package boardgame;

public abstract class Piece {
	
	protected Position position; // Variável do tipo protected para a peça receber uma posição
	private Board board; // Variável para receber o tabuleiro
	
	public Piece(Board board) { // Construtor recebendo o tabuleiro
		this.board = board;
		position = null; // Define a posição da peça como nula, sem posicionar ela no tabuleiro ainda
	}

	protected Board getBoard() { // Getter do board
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		
		for (int i = 0 ; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}
