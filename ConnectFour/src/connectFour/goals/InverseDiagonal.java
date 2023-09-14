package connectFour.goals;

import connectFour.Token;

public class InverseDiagonal extends Goal {

   private Token tokens[][];

   public InverseDiagonal(Token tokens[][]) {
      this.tokens = tokens;
   }

   public Boolean checkGoalRule() {
      return false;
   }

}
