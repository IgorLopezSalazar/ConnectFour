package connectFour.views;

import connectFour.controllers.PlayController;
import connectFour.controllers.ResumeController;
import connectFour.controllers.TokenController;

public abstract class View {
   
   private StartView startView;
   private PlayView playView;
   private ResumeView resumeView;

   public View(TokenController tokenController, PlayController playController, ResumeController resumeController) {
      this.startView = new StartView(tokenController);
      this.playView = new PlayView(playController);
      this.resumeView = new ResumeView(resumeController);
   }

   public void start() {
      this.startView.interact();
   }

   public void play() {
      this.playView.interact();
   }

   public boolean resume() {
      return this.resumeView.interact();
   }

}
