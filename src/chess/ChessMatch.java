package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	// Construtor instanciando o board como 8x8 e iniciando o setup
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	// Aqui é criado a matriz de peças do xadrez, "mat" do tipo matriz de ChessPiece é instanciado com as dimensões do tabuleiro e é feito o upcasting da peça para ChessPiece
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat; // Retorna a matriz do tipo ChessPiece.
	}
	
	// Método que performa o movimento de xadrez
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		// Transforma a posição do xadrez para a posição normal
		Position source = sourcePosition.toPosition(); 
		Position target = targetPosition.toPosition();
		validateSourcePosition(source); // Verifica se a posição possui alguma peça.
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target); // Variável "capturedPiece" recebe o método makeMove
		return (ChessPiece)capturedPiece; // Retorna a peça caputarada
	}

	// Realiza a movimentação e a captura
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source); // Peça "p" é removida do tabuleiro
		Piece capturedPiece = board.removePiece(target); // Peça "capturedPiece" é removida do tabuleiro
		board.placePiece(p, target); // Peça "p" é recolocada no alvo
		return capturedPiece; // Devolve a peça capturada
	}
	
	// Verifica se há alguma peça na posição de origem.
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) { 
			throw new ChessException("There is no piece on source position!");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		
		return board.piece(position).possibleMoves();
	}

	// Método que cria o setup inicial, isto é, o layout que o jogo deve começar.
	private void initialSetup() {
		// placeNewPiece instancia a linha, a coluna e a peça no tabuleiro.
		placeNewPiece('e', 8, new Rook(board, Color.BLACK)); 
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));

		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('g', 7, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
