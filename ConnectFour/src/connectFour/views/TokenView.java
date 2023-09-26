package connectFour.views;

import connectFour.types.Token;

public class TokenView {
   
   void write(Token token) {
      String string = token.getPrintValue();
      System.out.print(string);
   }

}
