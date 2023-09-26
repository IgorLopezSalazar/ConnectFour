package connectFour.views;

import connectFour.models.Game;
import connectFour.types.Coordinate;

public class PlayerView extends WithGameView {
   
   PlayerView (Game game) {
      super(game);
   }

   public void putToken() {
      Coordinate coordinate;
      coordinate = this.getCoordinate();
      this.game.putToken(coordinate);
      this.game.setLastPlacedCoordinate(coordinate);
   }

   private Coordinate getCoordinate() {
      return new CoordinateView(this.game).read();
   }
}
