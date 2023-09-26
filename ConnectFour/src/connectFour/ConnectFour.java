package connectFour;

import connectFour.controllers.PlayController;
import connectFour.controllers.ResumeController;
import connectFour.controllers.TokenController;
import connectFour.models.Board;
import connectFour.models.Game;
import connectFour.models.Turn;
import connectFour.views.View;

public class ConnectFour {
	private Game game;
    private View view;
    protected TokenController startController;
    protected PlayController playController;
    protected ResumeController resumeController;

	ConnectFour() {
		this.game = new Game();
        this.startController = new TokenController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = new View(this.startController, this.playController, this.resumeController);
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
