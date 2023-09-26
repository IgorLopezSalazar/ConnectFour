package connectFour.models;

import java.util.ArrayList;
import java.util.List;

import connectFour.types.Token;
import connectFour.views.MessageWriter;

public class Turn {
	static Integer PLAYER_NUMBER = 2;

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

	public void startPlayerTurn() {
		writeTurnStartMessage();
		players.get(playerIndex).putToken();
		writeGameFinishingMessage();
	}

	private void writeGameFinishingMessage() {
		if (board.isGoalCompleted()) {
			MessageWriter.println("Player " + (playerIndex + 1) + " (" + players.get(playerIndex).getToken() + ")"
					+ " wins the game.");
		} else if (board.isBoardCompleted()) {
			MessageWriter.println("The board is full. It is a tie.");
		}

	}

	public void switchPlayer() {
		playerIndex = (playerIndex + 1) % PLAYER_NUMBER;
	}

	private void writeTurnStartMessage() {
		MessageWriter.println("The turn of player " + (playerIndex + 1) + " (" + players.get(playerIndex).getToken()
				+ ")" + " starts.");
	}
}
