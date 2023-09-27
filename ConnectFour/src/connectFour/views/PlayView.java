package connectFour.views;

import connectFour.models.Game;

public class PlayView extends BaseView {

   PlayView(Game game) {
      super(game);
   }

   public void interact() {
      Boolean gameFinished;
      do {
         new PlayerView(this.game).putToken();
         new BoardView().write(this.game);
         gameFinished = this.game.anyLineCompleted() || this.game.isBoardCompleted();

         if (!gameFinished) {
            this.game.switchPlayer();
         }

      } while (!gameFinished);

      checkFinishingCondition();
   }

   public void checkFinishingCondition() {
      if (this.game.anyLineCompleted()) {
         new MessageView().writeln(Message.PLAYER_WIN,
               this.game.getActiveToken().name(),
               this.game.getActivePlayerId());
      } else {
         new MessageView().writeln(Message.BOARD_FULL);
      }
   }
}
