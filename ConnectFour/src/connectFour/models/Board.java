package connectFour.models;

import java.util.Arrays;

import connectFour.types.Coordinate;
import connectFour.types.Direction;
import connectFour.types.Line;
import connectFour.types.Token;

public class Board {
	public static Integer ROW_BOARD_SIZE = 6;
	public static Integer COLUMN_BOARD_SIZE = 7;
	Token[][] tokens;
	private Coordinate lastPlacedCoordinate;

	public Board() {
		tokens = new Token[ROW_BOARD_SIZE][COLUMN_BOARD_SIZE];
		this.initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < ROW_BOARD_SIZE; i++) {
			Arrays.fill(tokens[i], Token.NULL);
		}
	}

	public Boolean anyLineCompleted() {
		assert tokens[lastPlacedCoordinate.getRow()][lastPlacedCoordinate.getColumn()] != Token.NULL;

		Boolean anyLineCompleted = false;
		for (Direction direction : Direction.values()) {
			Line line = new Line(new Coordinate(lastPlacedCoordinate.getRow(), lastPlacedCoordinate.getColumn()), direction);
			anyLineCompleted = anyLineCompleted || checkLineCompletion(line);
		}
		return anyLineCompleted;
	}

	private Boolean checkLineCompletion(Line line) {
		Boolean lineAchieved = false;
		for (int i = 0; i < Line.CONNECTED_TOKEN_LINE && !lineAchieved; i++) {
			Boolean lineOutsideBoard = checkLineOutsideBoard(line);
			if (!lineOutsideBoard) {
				lineAchieved = checkSameTokenInLine(line);
			}
			line.iterateCoordinates();
		}
		return lineAchieved;
	}

	private Boolean checkLineOutsideBoard(Line line) {
		return Arrays.stream(line.getCoordinates())
					.anyMatch(coord -> !coordinateInsideBoard(coord));
	}

	private Boolean checkSameTokenInLine(Line line) {
		return Arrays.stream(line.getCoordinates())
					.map(coord -> this.getToken(coord))
					.distinct()
					.count() == 1;
	}

	public Boolean isBoardCompleted() {
		Boolean nullFound = false;

		for (int i = 0; i < ROW_BOARD_SIZE && !nullFound; i++) {
			for (int j = 0; j < COLUMN_BOARD_SIZE && !nullFound; j++) {
				if (tokens[i][j] == Token.NULL) {
					nullFound = true;
				}
			}
		}

		return !nullFound;
	}

	public void putToken(Token token, Coordinate coordinate) {
		tokens[coordinate.getRow()][coordinate.getColumn()] = token;
		lastPlacedCoordinate = coordinate;
	}

	public void reset() {
		this.initializeBoard();
	}

	public Token getToken(Coordinate coordinate) {
		return this.tokens[coordinate.getRow()][coordinate.getColumn()];
	}

	private boolean coordinateInsideBoard(Coordinate coordinate) {
		return (coordinate.getRow() >= 0 && coordinate.getRow() < Board.ROW_BOARD_SIZE)
				&& (coordinate.getColumn() >= 0 && coordinate.getColumn() < Board.COLUMN_BOARD_SIZE);
	}
}