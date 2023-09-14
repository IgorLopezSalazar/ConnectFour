package connectFour.goals;

import connectFour.Token;

public class Diagonal extends Goal {

   private Token tokens[][];

   public Diagonal(Token tokens[][]) {
      this.tokens = tokens;
   }

   public Boolean checkGoalRule() {
      Boolean goalCompleted = false;

      for(int row = 0; row < tokens.length && !goalCompleted; row++) {
         for(int column = 0; column < tokens[0].length && !goalCompleted; column++) {

            if (isDiagonalPosible(row, column)) {
               if (isDiagonalAchieved(row, column)) {
                  goalCompleted = true;
               }
            }
         }
      }

      return goalCompleted;
   }

   private Boolean isDiagonalPosible(Integer row, Integer column) {
      Boolean possible = false;

      if (row - (CONNECTED_TOKEN_GOAL - 1) >= 0) {
         if (column + (CONNECTED_TOKEN_GOAL - 1) < tokens[0].length) {
            possible = true;
         }
      }

      return possible;
   }

   private Boolean isDiagonalAchieved(Integer row, Integer column) {
      Boolean achieved = true;
      Token previousToken = null;
      Token newToken = null;

      for (int i = 0; i < CONNECTED_TOKEN_GOAL && achieved; i++) {
         newToken = tokens[row - i][column + i];
               
         if (!newToken.equals(Token.NULL)) {
            if (i != 0 && !newToken.equals(previousToken)) {
               achieved = false;
            }            
         }
         else {
            achieved = false;
         }

         previousToken = newToken;
      }

      return achieved;
   }

}
