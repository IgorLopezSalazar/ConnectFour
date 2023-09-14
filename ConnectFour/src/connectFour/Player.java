package connectFour;

import java.util.Scanner;

import connectFour.goals.MessageWriter;

public class Player {
	Scanner scanner;
	Token token;
	Board board;

	Player(Token token, Board board) {
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
		Integer x;
		MessageWriter.print("Introduce the column where the token ought to be put: ");
		x = Integer.parseInt(scanner.nextLine()) - 1;
		
		return x;
	}
}
