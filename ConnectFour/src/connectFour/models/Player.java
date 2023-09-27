package connectFour.models;

import connectFour.types.Token;

public class Player {
	Token token;

	public Player(Token token) {
		this.token = token;
	}

	public Token getToken() {
		return token;
	}
}
