package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		
		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition souce = UI.readChessPosition(entrada);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(souce);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(entrada);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(souce, target);
				
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
			} catch(ChessException e) {
				System.out.println(e.getMessage());
				entrada.nextLine();
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				entrada.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}

}
