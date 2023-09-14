package connectFour.goals;

import connectFour.Token;

public class Diagonal extends Goal {

   private Token tokens[][];

   public Diagonal(Token tokens[][]) {
      this.tokens = tokens;
   }

   public Boolean checkGoalRule() {
      return false;
   }

}
