package connectFour.controllers;

import connectFour.models.Game;
import connectFour.types.Coordinate;
import connectFour.types.Token;

public class PlayController extends Controller {

	public PlayController(Game game) {
		super(game);
	}

	public boolean areAllTokensOnBoard() {
        return this.game.areAllTokensOnBoard();
    }

//    public boolean isTicTacToe() {
//        return this.game.isTicTacToe();
//    }

//    public void next() {
//        this.game.next();
//    }

    public Token getActiveToken() {
        return this.game.getActiveToken();
    }

    public void putToken(Coordinate coordinate) {
        this.game.putToken(new Coordinate(coordinate.getRow(), coordinate.getColumn()));
    }

//    public Error getPutTokenError(Coordinate coordinate) {
//        return this.game.getPutTokenError(coordinate);
//    }
//
//    public Error getOriginMoveTokenError(Coordinate coordinate) {
//        return this.game.getOriginMoveTokenError(coordinate);
//    }
//
//    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
//        return this.game.getTargetMoveTokenError(origin, target);
//    }
}
