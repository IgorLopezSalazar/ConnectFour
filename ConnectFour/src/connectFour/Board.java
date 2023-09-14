package connectFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connectFour.goals.Column;
import connectFour.goals.Diagonal;
import connectFour.goals.Goal;
import connectFour.goals.InverseDiagonal;
import connectFour.goals.MessageWriter;
import connectFour.goals.Row;

public class Board {
	static Integer X_BOARD_SIZE = 6;
	static Integer Y_BOARD_SIZE = 7;
	List<Goal> goals;
	Token[][] tokens;

	Board() {
		tokens = new Token[X_BOARD_SIZE][Y_BOARD_SIZE];
		for (int i = 0; i < X_BOARD_SIZE; i++) {
			Arrays.fill(tokens[i], Token.NULL);
		}
		establishPossibleGoals();
	}

	private List<Goal> establishPossibleGoals() {
		goals = new ArrayList<>();
		goals.add(new Column(tokens));
		goals.add(new Row(tokens));
		goals.add(new Diagonal(tokens));
		goals.add(new InverseDiagonal(tokens));
		return goals;
	}

	public Boolean isGoalCompleted() {
		Boolean anyGoalCompleted = false;
		for (Goal goal : goals) {
			anyGoalCompleted = anyGoalCompleted || goal.checkGoalRule();
		}
		return anyGoalCompleted;
	}

	public Boolean isBoardCompleted() {
		Boolean nullFound = false;

		for (int i = 0; i < X_BOARD_SIZE && !nullFound; i++) {
			for (int j = 0; j < Y_BOARD_SIZE && !nullFound; j++) {
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
		for (int i = 0; i < X_BOARD_SIZE && !possibleRowFound; i++) {
			if (tokens[i][column] == Token.NULL) {
				possibleRowFound = true;
				rowPosition = i;
			}
		}

		if (!possibleRowFound) {
			MessageWriter.println("Invalid position for token - There is no more space in that column!");
		} else {
			tokens[rowPosition][column] = token;
			writeBoard();
		}

		return possibleRowFound;

	}

	public Token[][] getTokens() {
		return tokens;
	}

	private void writeBoard() {
		writeTopBottomLines();
		for (int i = X_BOARD_SIZE - 1; i >= 0; i--) {
			for (int j = 0; j < Y_BOARD_SIZE; j++) {
				MessageWriter.print("|");
				MessageWriter.print(tokens[i][j].getPrintValue());
				MessageWriter.print("|");
			}
			MessageWriter.println("");
		}
		writeTopBottomLines();
	}

	private void writeTopBottomLines() {
		for (int i = 0; i < Y_BOARD_SIZE * 3; i++) {
			MessageWriter.print("-");
		}
		MessageWriter.println("");
	}
}
