package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces; // Variável to tipo matriz de peças recendo o nome de pieces.

	public Board(int rows, int columns) {
		
		//No construtor, definimos um tratamento de exceção, dizendo que o tabuleiro deve ter, no mínimo, 1 linha e 1 coluna.
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}

		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; // A matriz "pieces" recebe a instancia de Pieces com a quantidade de linhas e colunas
	}

	// Getters
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	// Criando o método "Piece". Nele é verificado se a posição existe, e retorna a peça contida na linha e coluna da matriz recebidas como argumentos.
	public Piece piece(int row, int column) {

		if (!positionExists(row, column)) {
			throw new BoardException("Position must exists!");
		}
		return pieces[row][column];
	}

	// Sobrecarga para ser possível instanciar a peça com um argumento do tipo position.
	public Piece piece(Position position) {

		if (!positionExists(position)) { 
			throw new BoardException("Position must exists!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	// Método que coloca as peças, recebe a peça e a posição, checa se já há alguma peça no local e posteriormente fiz que a matriz "pieces" recebe a peça e atualiza a posição da peça que antes era nulo.
	public void placePiece(Piece piece, Position position) {

		if (thereIsAPiece(position)) { // Verifica se há alguma peça.
			throw new BoardException("Position is already occupied"); //Booleano verdadeiro = tem peça.
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	// Método que inicia a implementação de movimentação, removendo peças.
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position must exists!"); // Checa se a posição existe.
		}
		if (piece(position) == null) { // Se a posição da peça for nulo, retorne nulo.
			return null;
		}
		Piece aux = piece(position); // "aux" recebe a peça.
		aux.position = null; // Define a posição de aux como nulo.
		pieces[position.getRow()][position.getColumn()] = null; // A peça na matriz "pieces" tem sua posição definida como nulo.
		return aux; // Retorna o aux.
	}

	// Método que verifica se a posição existe pelo argumento position.
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn()); // Ele chama sua sobrecarga, passando os métodos getters de position
	}

	// Método que verifica se a posição existe pela coordenada.
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns; // Teste para ver se a posição existe
	}

	// Método que verifica se na posição informada há alguma peça.
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position must exists!");
			
		}
		return piece(position) != null; // Retorna o booleando do teste se a posição do método peça é diferente de nulo
	}

}
