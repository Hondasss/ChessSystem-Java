package boardgame;

public class BoardException extends RuntimeException { // Aborda toda exceção "RuntimeException"

	private static final long serialVersionUID = 1L;
	
	public BoardException(String txt) { // COnstrutor que comporta a mensagem a ser exibida.
		super(txt);
	}
	

}
