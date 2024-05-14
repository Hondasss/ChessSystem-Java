package boardgame;

public class Position {
	
	private int row; // Criando uma variável para comportar a linha
	private int column; // Criando uma variável para comportar a coluna
	
	public Position() { // Construtor base da classe Position
	}

	public Position(int row, int column) { // Construtor com argumentos ROW e COLUMN da classe Position
		this.row = row;
		this.column = column;
	}
	
	//Getters e Setters
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	@Override
	public String toString() {
		return row + ", " + column;
	}
	
	
}
