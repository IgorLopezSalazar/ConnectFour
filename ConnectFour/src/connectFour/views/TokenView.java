package connectFour.views;

import connectFour.types.Token;

public class TokenView {
	
	String[] printValues = {" ", "Y", "R"};

   void write(Token token) {
      new MessageView().write(printValues[token.ordinal()]);
   }
}
