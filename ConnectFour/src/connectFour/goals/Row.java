package connectFour.goals;

import connectFour.Token;

public class Row extends Goal {

   private Token tokens[][];

   Row(Token tokens[][]) {
      this.tokens = tokens;
   }

   public Boolean checkGoalRule() {
      Boolean goalCompleted = false;

      Integer contador = 0;
      Token previousToken = null;
      Token newToken = null;

      for(int i = 0; i < tokens.length && !goalCompleted; i++) {
         for(int j = 0; j < tokens[0].length && !goalCompleted; j++) {
            newToken = tokens[i][j];

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
