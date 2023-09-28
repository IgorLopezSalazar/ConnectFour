package connectFour.views;

import connectFour.models.Board;
import connectFour.models.Game;
import connectFour.types.Coordinate;

public class BoardView extends BaseView {

	BoardView(Game game) {
		super(game);
	}

	public void write() {
		new MessageView().writeln(Message.TOP_BOTTOM_LINES);
		for (int i = 0; i < Board.ROW_BOARD_SIZE; i++) {
			new MessageView().write(Message.VERTICAL_CHARACTER);
			for (int j = 0; j < Board.COLUMN_BOARD_SIZE; j++) {
				new TokenView().write(this.game.getToken(new Coordinate(i, j)));
				new MessageView().write(Message.VERTICAL_CHARACTER);
			}
			System.out.println();
		}
		new MessageView().writeln(Message.TOP_BOTTOM_LINES);
	}
}
