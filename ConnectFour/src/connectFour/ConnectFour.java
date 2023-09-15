package connectFour;

public class ConnectFour {
	Turn turn;
	Board board;

	ConnectFour() {
		board = new Board();
		turn = new Turn(board);
	}

	private void playGame() {
		board.writeGameBoardInfo();
		while (!board.isGoalCompleted() && !board.isBoardCompleted()) {
			turn.startPlayerTurn();
			turn.switchPlayer();
		}
	}

	public static void main(String[] args) {
		ConnectFour connectFour = new ConnectFour();
		connectFour.playGame();
	}
}
