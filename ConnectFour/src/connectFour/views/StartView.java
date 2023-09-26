package connectFour.views;

import connectFour.controllers.TokenController;

public class StartView {

   private TokenController tokenControler;
   
   StartView (TokenController tokenControler) {
      this.tokenControler = tokenControler;
   }
   
   public void interact () {
      new MessageView().writeln(Message.TITLE);
      new BoardView().write(this.tokenControler);
   }
}
