package connectFour.views;

public enum Message {

   TITLE ("Welcome to Connect 4"),
   TOP_BOTTOM_LINES ("---------------------"),
   VERTICAL_CHARACTER ("|"),
   ENTER_COLUMN_TO_PUT ("Introduce the column where the token ought to be put: "),
   NO_VALID_CHARACTER ("\nYou haven't introduced a valid number. Please try again."),
   NO_VALID_COLUMN ("\nInvalid position for token - That column doesn't exist!"),
   NO_SPACE_IN_COLUMN ("\nInvalid position for token - There is no more space in that column!"),
   BOARD_FULL ("The board is full. It is a tie."),
   PLAYER_WIN("Player #player#(#token#) wins the game."),
   PLAYER_TURN("The turn of player #player#(#token#) starts."),
   RESUME("Do you want to play another match?(y/n):"),
   RESUME_ANSWER_INCORRECT("Incorrect answer. Please answer yes (y) or no (n).");


   private String message;

   Message (String message) {
      this.message = message;
   }
   
   @Override
   public String toString() {
      return message;
   }
}
