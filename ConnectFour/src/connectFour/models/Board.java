package connectFour.models;

import java.util.Arrays;

import connectFour.types.Coordinate;
import connectFour.types.Direction;
import connectFour.types.Goal;
import connectFour.types.Token;
import connectFour.views.MessageView;

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

	public Boolean anyGoalCompleted() {
		Boolean anyGoalCompleted = false;
		for (Direction direction : Direction.values()) {
			Goal goal = new Goal(lastPlacedCoordinate, direction);
			anyGoalCompleted = anyGoalCompleted || checkGoalCompletion(goal);
		}
		return anyGoalCompleted;
	}

	public Boolean checkGoalCompletion(Goal goal) {
		Boolean goalAchieved = false;
		for (int i = 0; i < Goal.CONNECTED_TOKEN_GOAL && !goalAchieved; i++) {
			Boolean goalOutsideBoard = Arrays.stream(goal.getCoordinates())
					.anyMatch(coord -> !coordinateInsideBoard(coord));
			if (goalOutsideBoard) {
				goalAchieved = Arrays.stream(goal.getCoordinates()).map(coord -> this.getToken(coord)).distinct()
						.count() == 1;
			}

			goal.iterateCoordinates();
		}
		return goalAchieved;
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

	public Boolean putToken(Token token, Integer column) {
		int rowPosition = 0;
		Boolean possibleRowFound = false;

		if (column >= 0 && column < COLUMN_BOARD_SIZE) {
			for (int i = 0; i < ROW_BOARD_SIZE && !possibleRowFound; i++) {
				if (tokens[i][column] == Token.NULL) {
					possibleRowFound = true;
					rowPosition = i;
				}
			}

			if (!possibleRowFound) {
				MessageView.println("\nInvalid position for token - There is no more space in that column!");
			} else {
				tokens[rowPosition][column] = token;
				writeBoard();
				/////////// ---------------- hay que guardar el ultimo token que se ha puessto
				/////////// -----_---------------
			}
		} else {
			MessageView.println("\nInvalid position for token - That column doesn't exist!");
		}
		return possibleRowFound;

	}

	// private void writeBoard() {
	// writeTopBottomLines();
	// for (int i = ROW_BOARD_SIZE - 1; i >= 0; i--) {
	// for (int j = 0; j < COLUMN_BOARD_SIZE; j++) {
	// MessageView.print("|");
	// MessageView.print(tokens[i][j].getPrintValue());
	// MessageView.print("|");
	// }
	// MessageView.println("");
	// }
	// writeTopBottomLines();
	// }

	// private void writeTopBottomLines() {
	// for (int i = 0; i < COLUMN_BOARD_SIZE * 3; i++) {
	// MessageView.print("-");
	// }
	// MessageView.println("");
	// }

	// public void writeGameBoardInfo() {
	// MessageView.println("The board size is " + COLUMN_BOARD_SIZE + " x " +
	// ROW_BOARD_SIZE + ".\n");
	// }

	public void reset() {

	}

	public Token getToken(Coordinate coordinate) {
		return this.tokens[coordinate.getRow()][coordinate.getColumn()];
	}

	public boolean coordinateInsideBoard(Coordinate coordinate) {
		return (coordinate.getRow() >= 0 && coordinate.getRow() < Board.ROW_BOARD_SIZE)
				&& (coordinate.getColumn() >= 0 && coordinate.getColumn() < Board.COLUMN_BOARD_SIZE);
	}
}