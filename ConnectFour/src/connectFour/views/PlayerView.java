package connectFour.views;

import connectFour.models.Game;
import connectFour.types.Coordinate;

public class PlayerView extends BaseView {

	PlayerView(Game game) {
		super(game);
	}

	public void putToken() {
		new MessageView().writeln(Message.PLAYER_TURN, this.game.getActiveToken().name(),
				this.game.getActivePlayerId());
		Coordinate coordinate = new CoordinateView(this.game).read();
		this.game.putToken(coordinate);
	}
}
