package connectFour.models;

import connectFour.types.Coordinate;
import connectFour.types.Token;

public class Player {
	Token token;
	Board board;

	public Player(Token token, Board board) {
		this.token = token;
		this.board = board;
	}
	
	public void putToken(Coordinate coordinate) {
		this.board.putToken(this.token, coordinate);
	}

	public Token getToken() {
		return token;
	}
}
