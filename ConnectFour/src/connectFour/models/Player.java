package connectFour.models;

import java.util.Scanner;

import connectFour.types.Token;
import connectFour.views.MessageView;

public class Player {
	Scanner scanner;
	Token token;
	Board board;

	public Player(Token token, Board board) {
		scanner =new Scanner(System.in);  
		this.token = token;
		this.board = board;
	}

	public void putToken() {
		Boolean tokenPlaced = false;
		
		while (!tokenPlaced) {
			tokenPlaced = board.putToken(token, readColumn());
		}	
	}
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Token getToken() {
		return token;
	}

	private Integer readColumn() {
		Integer x = null;
		while (x == null) {
			MessageView.print("Introduce the column where the token ought to be put: ");
			try {
				x = Integer.parseInt(scanner.nextLine()) - 1;
			} catch (NumberFormatException e) {
				MessageView.println("\nYou haven't introduced a valid number. Please try again.");
			}
		}
		
		
		return x;
	}
}
