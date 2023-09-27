package connectFour.views;

import connectFour.types.Token;

public class TokenView {

   void write(Token token) {
      new MessageView().write(token.getPrintValue());
   }
}
