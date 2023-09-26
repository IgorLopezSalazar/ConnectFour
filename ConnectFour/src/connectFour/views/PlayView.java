package connectFour.views;

import connectFour.models.Game;

public class PlayView extends WithGameView {

   PlayView(Game game) {
      super(game);
   }

   public void interact() {
      do {
         new PlayerView(this.game).interact();
         this.game.switchPlayer();
         new BoardView().write(this.game);
      } while (!this.game.anyGoalCompleted());
      new MessageView().writeln(Message.PLAYER_WIN, this.game.getActiveToken().getPrintValue());
   }
}
