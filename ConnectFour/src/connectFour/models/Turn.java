package connectFour.models;

import java.util.ArrayList;
import java.util.List;

import connectFour.types.Coordinate;
import connectFour.types.Token;

public class Turn {
	static final Integer PLAYER_NUMBER = 2;

	Board board;
	List<Player> players;
	private Integer playerIndex;

	public Turn(Board board) {
		playerIndex = 0;
		this.board = board;
		players = new ArrayList<>();
		for (int i = 1; i <= PLAYER_NUMBER; i++) {
			players.add(new Player(Token.values()[i], board));
		}
	}

	public void switchPlayer() {
		this.playerIndex = (this.playerIndex + 1) % PLAYER_NUMBER;
	}

	public Token getActiveToken() {
		return this.getActivePlayer().getToken();
	}

	private Player getActivePlayer() {
		return this.players.get(this.playerIndex);
	}

	public void putToken(Coordinate coordinate) {
		this.getActivePlayer().putToken(coordinate);
	}

	public Integer getActivePlayerId() {
		return this.playerIndex;
	}

	public void reset() {
		playerIndex = 0;
	}
}
