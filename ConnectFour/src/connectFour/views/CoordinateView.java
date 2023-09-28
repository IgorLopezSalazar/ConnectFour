package connectFour.views;

import connectFour.models.Game;
import connectFour.types.Coordinate;

public class CoordinateView extends BaseView {

	CoordinateView(Game game) {
		super(game);
	}

	public Coordinate read() {
		Integer row;
		Integer column;

		do {
			column = this.awaitUntilValidColumn();
			row = this.game.findValidRowForColumn(column);
			if (row == null) {
				new MessageView().writeln(Message.NO_SPACE_IN_COLUMN);
			}
		} while (row == null);

		return new Coordinate(row, column);
	}

	private Integer awaitUntilValidColumn() {
		Integer column;
		Boolean validColumn;

		do {
			column = this.readColumn();
			validColumn = this.game.checkColumnPossible(column);

			if (!validColumn) {
				new MessageView().writeln(Message.NO_VALID_COLUMN);
			}
		} while (!validColumn);

		return column;
	}

	private Integer readColumn() {
		Integer column = null;
		do {
			new MessageView().write(Message.ENTER_COLUMN_TO_PUT);

			try {
				column = Integer.parseInt(new ReadView(game).readLine()) - 1;
			} catch (NumberFormatException e) {
				new MessageView().writeln(Message.NO_VALID_CHARACTER);
			}
		} while (column == null);

		return column;
	}
}
