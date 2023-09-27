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

	protected void play() {
		do {
			this.view.start();
			this.view.play();
		} while (this.view.resume());
	}

	public static void main(String[] args) {
		ConnectFour connectFour = new ConnectFour();
		connectFour.play();
	}
}
