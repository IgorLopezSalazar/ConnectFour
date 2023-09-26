package connectFour.models;

import java.util.Scanner;

import connectFour.types.Token;

public class Player {
	Scanner scanner;
	Token token;
	Board board;

	public Player(Token token, Board board) {
		scanner =new Scanner(System.in);  
		this.token = token;
		this.board = board;
	}

	public Token getToken() {
		return token;
	}
}
