package connectFour.goals;

import connectFour.Token;

public class InverseDiagonal extends Goal {

   private Token tokens[][];

   InverseDiagonal(Token tokens[][]) {
      this.tokens = tokens;
   }

   public Boolean checkGoalRule() {
      return null;
   }

}
