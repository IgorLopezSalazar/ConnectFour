package connectFour.views;

public enum Message {

   TITLE ("Welcome to Connect 4"),
   TOP_BOTTOM_LINES ("---------------------");


   private String message;

   Message (String message) {
      this.message = message;
   }
   
   @Override
   public String toString() {
      return message;
   }
}
