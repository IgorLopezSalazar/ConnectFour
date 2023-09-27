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

    public Integer getActivePlayerId() {
        return this.turn.getActivePlayerId() + 1;
    }

    public Token getActiveToken() {
        return this.turn.getActiveToken();
    }

    public Token getToken(Coordinate coordinate) {
        return this.board.getToken(coordinate);
    }

    public boolean isBoardCompleted() {
        return this.board.isBoardCompleted();
    }

    public boolean anyLineCompleted() {
        return this.board.anyLineCompleted();
    }

    public void putToken(Coordinate coordinate) {
        this.board.putToken(this.turn.getActiveToken(), coordinate);
    }
}
