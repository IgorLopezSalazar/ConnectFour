package connectFour.models;

import connectFour.types.Coordinate;
import connectFour.types.Token;

public class Game {
	private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public void switchPlayer() {
        this.turn.switchPlayer();
    }

    public Token getActiveToken() {
        return this.turn.getActiveToken();
    }

    public Token getToken(Coordinate coordinate) {
        return this.board.getToken(coordinate);
    }
    
    public boolean areAllTokensOnBoard() {
        return this.board.isBoardCompleted();
    }
    
    public void putToken(Coordinate coordinate) {
        this.turn.startPlayerTurn();
    }

    public void setToken(Coordinate coordinate) {
    }

   public void setLastPlacedCoordinate(Coordinate coordinate) {
   }

//    public Error getPutTokenError(Coordinate coordinate) {
//        return this.turn.getPutTokenError(coordinate);
//    }
//
//    public void moveToken(Coordinate origin, Coordinate target) {
//        this.turn.moveToken(origin, target);
//    }
//
//    public Error getOriginMoveTokenError(Coordinate coordinate) {
//        return this.turn.getOriginMoveTokenError(coordinate);
//    }
//
//    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
//        return this.turn.getTargetMoveTokenError(origin, target);
//    }
}
