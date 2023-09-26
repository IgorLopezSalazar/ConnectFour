package connectFour.controllers;

import connectFour.models.Game;
import connectFour.types.Coordinate;
import connectFour.types.Token;

public abstract class Controller {
	protected Game game;

	Controller(Game game) {
		this.game = game;
	}

//	public Token getToken(Coordinate coordinate) {
//		return this.game.getToken(coordinate);
//	}
}
