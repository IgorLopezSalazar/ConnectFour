package connectFour.goals;

import connectFour.Token;

public class Column extends Goal {

   private Token tokens[][];

   Column(Token tokens[][]) {
      this.tokens = tokens;
   }

   public Boolean checkGoalRule() {
      return null;
   }

}
