package connectFour.views;

import java.io.Console;
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
      boolean correct;
      Coordinate coordinate;
      Integer column;

      do {
         coordinate = this.calculateCoordinate(this.readColumn());
         correct = this.setToken(coordinate);         
      } while (correct);
      return squareBoundedCoordinate;
   }

   private Integer readColumn() {
      try (Scanner scanner = new Scanner(System.in)) {
         Integer column = null;
         Integer tmpColumn = null;
         do {
            new MessageView().write(Message.ENTER_COLUMN_TO_PUT);
            
            try {
               tmpColumn = Integer.parseInt(scanner.nextLine()) - 1;
            } catch (NumberFormatException e) {
               new MessageView().write(Message.NO_VALID_CHARACTER);
            }

            if (checkColumnPossible(tmpColumn)) {
               column = tmpColumn;
            }
         } while (column == null);

         return column;
      }
	}

   private Boolean checkColumnPossible(Integer column) {
      Boolean possible  = false;

      if (column >= 0 && column < Board.COLUMN_BOARD_SIZE) {
            possible = true;
         }
      else {
         new MessageView().write(Message.NO_VALID_COLUMN);
      }

      return possible;
   }

   private Coordinate calculateCoordinate(Integer column) {
      Integer rowPosition = null;
      Coordinate coordinate = null;

			for (int i = 0; i < Board.ROW_BOARD_SIZE; i++) {
				if (game.getToken(new Coordinate(i, column)) == Token.NULL) {
					rowPosition = i;
               coordinate = new Coordinate(rowPosition, column);
				}
			}

		return coordinate;
   }

   private boolean setToken(Coordinate coordinate) {
      boolean correct = coordinate != null;
      if (correct) {
			game.setToken(coordinate);
         game.setLastPlacedCoordinate(coordinate);
         
		} else {
         new MessageView().write(Message.NO_SPACE_IN_COLUMN);
		}
      return correct;
   }
}
