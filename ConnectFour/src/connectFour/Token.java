package connectFour;

public enum Token {

   NULL, YELLOW, RED;

   public Token get(Integer index) {
      Token resultToken = null;
      
      for (Token token : Token.values()) {
         if (token.ordinal() == index) {
            resultToken = token;
         }
      }

      return resultToken;
   }

}
