package connectFour.views;

import connectFour.models.Board;
import connectFour.models.Game;
import connectFour.types.Coordinate;

public class BoardView {

   public void write(Game game) {
      new MessageView().writeln(Message.TOP_BOTTOM_LINES);
      for (int i = Board.ROW_BOARD_SIZE - 1; i >= 0; i--) {
         new MessageView().write(Message.VERTICAL_CHARACTER);
			for (int j = 0; j < Board.COLUMN_BOARD_SIZE; j++) {
            new TokenView().write(game.getToken(new Coordinate(i, j)));
				new MessageView().write(Message.VERTICAL_CHARACTER);
			}
			System.out.println();
		}
      new MessageView().writeln(Message.TOP_BOTTOM_LINES);
   }
}
