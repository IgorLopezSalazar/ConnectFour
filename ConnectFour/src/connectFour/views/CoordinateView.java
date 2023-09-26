package connectFour.views;

import java.util.Scanner;

import connectFour.models.Board;
import connectFour.models.Game;
import connectFour.types.Coordinate;
import connectFour.types.Token;

public class CoordinateView extends WithGameView {

	CoordinateView(Game game) {
		super(game);
	}

	public Coordinate read() {
		Integer row;
		Integer column;
		
		do {
			column = awaitUntilValidColumn();
			row = findValidRowForColumn(column);
		} while (row != null);

		return new Coordinate(row, column);
	}

	private Integer awaitUntilValidColumn() {
		Integer column;

		do {
			column = this.readColumn();
		} while (!checkColumnPossible(column));
		
		return column;
	}

	private Integer readColumn() {
		try (Scanner scanner = new Scanner(System.in)) {
			Integer column = null;
			do {
				new MessageView().write(Message.ENTER_COLUMN_TO_PUT);

				try {
					column = Integer.parseInt(scanner.nextLine()) - 1;
				} catch (NumberFormatException e) {
					new MessageView().write(Message.NO_VALID_CHARACTER);
				}
			} while (column == null);

			return column;
		}
	}

	private Boolean checkColumnPossible(Integer column) {
		Boolean possible = false;

		if (column >= 0 && column < Board.COLUMN_BOARD_SIZE) {
			possible = true;
		} else {
			new MessageView().write(Message.NO_VALID_COLUMN);
		}

		return possible;
	}

	private Integer findValidRowForColumn(Integer column) {
		Integer rowPosition = null;

		for (int i = 0; i < Board.ROW_BOARD_SIZE; i++) {
			if (game.getToken(new Coordinate(i, column)) == Token.NULL) {
				rowPosition = i;
			}
		}
		
		if(rowPosition == null) {
			new MessageView().write(Message.NO_SPACE_IN_COLUMN);
		}

		return rowPosition;
	}
}
