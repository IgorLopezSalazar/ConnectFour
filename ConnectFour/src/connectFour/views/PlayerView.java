package connectFour.views;

import connectFour.models.Game;
import connectFour.types.Coordinate;

public class PlayerView extends WithGameView {
   
   PlayerView (Game game) {
      super(game);
   }

   public void putToken() {
	  new MessageView().writeln(Message.PLAYER_TURN, this.game.getActiveToken().name(), this.game.getActivePlayerId());
      Coordinate coordinate = this.getCoordinate();
      this.game.putToken(coordinate);
   }

   private Coordinate getCoordinate() {
      return new CoordinateView(this.game).read();
   }
}
