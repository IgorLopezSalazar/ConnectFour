package connectFour.views;

import connectFour.models.Game;

abstract class BaseView {

   protected Game game;

   BaseView(Game game) {
      this.game = game;
   }
}
