package connectFour.views;

import connectFour.models.Game;

public class ResumeView extends BaseView {
	private static final String AFFIRMATIVE = "y";
	private static final String NEGATIVE = "n";

	ResumeView(Game game) {
		super(game);
	}

	boolean interact() {
		String response;
		Boolean validAnswer = false;
		do {
			new MessageView().write(Message.RESUME);
			response = new ReadView(game).readLine();
			validAnswer = isAffirmative(response.toLowerCase()) || isNegative(response.toLowerCase());
			
			if(!validAnswer) {
				new MessageView().writeln(Message.RESUME_ANSWER_INCORRECT);
			}
		} while (!validAnswer);
		
		if (isAffirmative(response.toLowerCase())) {
			this.game.reset();
		}
		return isAffirmative(response.toLowerCase());
	}

	private boolean isAffirmative(String response) {
		return response.equals(ResumeView.AFFIRMATIVE);
	}

	private boolean isNegative(String response) {
		return response.equals(ResumeView.NEGATIVE);
	}
}
