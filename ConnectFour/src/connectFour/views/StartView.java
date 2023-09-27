package connectFour.views;

import connectFour.models.Game;

public class StartView extends BaseView {

   StartView(Game game) {
      super(game);
   }

   public void interact() {
      new MessageView().writeln(Message.TITLE);
      new BoardView().write(this.game);
   }
}
