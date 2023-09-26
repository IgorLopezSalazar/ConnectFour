package connectFour.views;

import connectFour.models.Game;
import connectFour.types.Coordinate;

public class PlayerView extends WithGameView {
   
   PlayerView (Game game) {
      super(game);
   }

   void interact() {
      if (!this.game.areAllTokensOnBoard()) {
         this.putToken();
      } else {
         this.gasdasda
      }
   }

   private void putToken() {
      Coordinate coordinate;
      Error error;
      do {
         coordinate = this.getCoordinate();
         error = this.getPutTokenError(coordinate);
      } while (!error.isNull());
      this.game.putToken(coordinate);
   }

   private Coordinate getCoordinate() {
      assert message != null;

      return new CoordinateView(this.game).read();
  }
}
