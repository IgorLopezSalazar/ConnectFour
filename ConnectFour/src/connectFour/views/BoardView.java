package connectFour.views;

import java.util.Arrays;

import connectFour.models.Board;
import connectFour.models.Game;
import connectFour.types.Coordinate;
import connectFour.types.Direction;
import connectFour.types.Line;
import connectFour.types.Token;

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

	public Boolean anyLineCompleted() {
		assert this.game.getLastPlacedToken() != Token.NULL;

		Boolean anyLineCompleted = false;
		Coordinate lastPlacedCoordinate = this.game.getLastPlacedCoordinate();
		for (Direction direction : Direction.values()) {
			Line line = new Line(new Coordinate(lastPlacedCoordinate.getRow(), lastPlacedCoordinate.getColumn()),
					direction);
			anyLineCompleted = anyLineCompleted || checkLineCompletion(line);
		}
		return anyLineCompleted;
	}
	
	public boolean isBoardCompleted() {
        return this.game.isBoardCompleted();
    }

	private Boolean checkLineCompletion(Line line) {
		Boolean lineAchieved = false;
		for (int i = 0; i < Line.CONNECTED_TOKEN_LINE && !lineAchieved; i++) {
			Boolean lineOutsideBoard = checkLineOutsideBoard(line);
			if (!lineOutsideBoard) {
				lineAchieved = this.game.checkSameTokenInLine(line);
			}
			line.iterateCoordinates();
		}
		return lineAchieved;
	}

	private Boolean checkLineOutsideBoard(Line line) {
		return Arrays.stream(line.getCoordinates()).anyMatch(coord -> !this.game.coordinateInsideBoard(coord));
	}
}
