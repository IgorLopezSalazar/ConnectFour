package connectFour.views;

import connectFour.controllers.PlayController;

public class PlayView {
   
   private PlayController playController;
   
   PlayView (PlayController playController) {
      this.playController = playController;
   }

   public void interact() {
      // do {
      //    new PlayerView(this.playController).interact();
      //    this.playController.next();
      //    new BoardView().write(this.playController);
      // } while (!this.playController.isTicTacToe());
      // new MessageView().writeln(Message.PLAYER_WIN, this.playController.getToken());
   }
}
