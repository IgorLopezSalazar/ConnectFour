package connectFour.types.goals;

import connectFour.types.Token;

public class Column extends Goal {

   private Token tokens[][];

   public Column(Token tokens[][]) {
      this.tokens = tokens;
   }

   public Boolean checkGoalRule() {
      Boolean goalCompleted = false;

      Integer contador = 0;
      Token previousToken = null;
      Token newToken = null;

      for(int column = 0; column < tokens[0].length && !goalCompleted; column++) {
         for(int row = 0; row < tokens.length && !goalCompleted; row++) {
            newToken = tokens[row][column];

            if (!newToken.equals(Token.NULL)) {
               if (!newToken.equals(previousToken)) {
                  contador = 0;
               }

               contador++;

               if (contador >= CONNECTED_TOKEN_GOAL) {
                  goalCompleted = true;
               }               
            }
            else {
               contador = 0;
            }
            
            previousToken = newToken;
         }
      }

      return goalCompleted;
   }

}
