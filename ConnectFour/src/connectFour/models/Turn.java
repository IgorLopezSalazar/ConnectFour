package connectFour.models;

import java.util.ArrayList;
import java.util.List;

import connectFour.types.Token;
import connectFour.views.MessageView;

public class Turn {
	static Integer PLAYER_NUMBER = 2;

	Board board;
	List<Player> players;
	private Integer playerIndex;

	public Turn(Board board) {
		playerIndex = 0;
		this.board = board;
		Integer totalTokens = Board.COLUMN_BOARD_SIZE * Board.ROW_BOARD_SIZE;
		players = new ArrayList<>();
		for (int i = 1; i <= PLAYER_NUMBER; i++) {
			players.add(new Player(Token.values()[i], board, totalTokens / PLAYER_NUMBER));
		}
	}

	public void startPlayerTurn() {
		writeTurnStartMessage();
		players.get(playerIndex).putToken();
		writeGameFinishingMessage();
	}

	private void writeGameFinishingMessage() {
		if (board.isGoalCompleted()) {
			///MessageView.println("Player " + (playerIndex + 1) + " (" + players.get(playerIndex).getToken() + ")"
			///		+ " wins the game.");
		} else if (board.isBoardCompleted()) {
			///MessageView.println("The board is full. It is a tie.");
		}

	}

	public void switchPlayer() {
		playerIndex = (playerIndex + 1) % PLAYER_NUMBER;
	}

	private void writeTurnStartMessage() {
		///MessageView.println("The turn of player " + (playerIndex + 1) + " (" + players.get(playerIndex).getToken()
		///		+ ")" + " starts.");
	}
	
	private Player getActivePlayer() {
        return this.players.get(this.playerIndex);
    }
	
	Token getActiveToken() {
        return this.getActivePlayer().getToken();
    }

	public void reset() {

	}
}
