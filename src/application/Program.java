package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
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
			} catch(ChessException e) {
				System.out.println(e.getMessage());
				entrada.nextLine();
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				entrada.nextLine();
			}
			
		}
	}

}
