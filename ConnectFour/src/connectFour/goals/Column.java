package connectFour.goals;

import connectFour.Token;

public class Column extends Goal {

   private Token tokens[][];

   public Column(Token tokens[][]) {
      this.tokens = tokens;
   }

   public Boolean checkGoalRule() {
      return false;
   }

}
