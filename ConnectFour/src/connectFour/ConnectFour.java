package connectFour;

import connectFour.models.Game;
import connectFour.views.View;

public class ConnectFour {
	private Game game;
    private View view;

	ConnectFour() {
		this.game = new Game();
        this.view = new View(this.game);
	}

	private void playGame() {
		game.writeGameBoardInfo();
		while (!board.anyGoalCompleted() && !board.isBoardCompleted()) {
			turn.startPlayerTurn();
			turn.switchPlayer();
		}
	}

	public static void main(String[] args) {
		ConnectFour connectFour = new ConnectFour();
		connectFour.playGame();
	}
	
//	protected void play() {
//        do {
//            this.view.start();
//            this.view.play();
//        } while (this.view.resume());
//    }
}
