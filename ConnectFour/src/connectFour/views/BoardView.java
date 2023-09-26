package connectFour.views;

import connectFour.controllers.Controller;
import connectFour.models.Board;
import connectFour.types.Coordinate;

public class BoardView {

   void write(Controller controller) {
      new MessageView().writeln(Message.TOP_BOTTOM_LINES);
      for (int i = Board.ROW_BOARD_SIZE - 1; i >= 0; i--) {
         new MessageView().write(Message.VERTICAL_CHARACTER);
			for (int j = 0; j < Board.COLUMN_BOARD_SIZE; j++) {
            //new TokenView().write(controller.getToken(new Coordinate(i, j)));
				new MessageView().write(Message.VERTICAL_CHARACTER);
			}
			System.out.println();
		}
      new MessageView().writeln(Message.TOP_BOTTOM_LINES);
   }
}
