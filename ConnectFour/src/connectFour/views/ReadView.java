package connectFour.views;

import java.util.Scanner;

import connectFour.models.Game;

public class ReadView extends WithGameView {
	Scanner scanner;
	
	ReadView(Game game) {
		super(game);
		scanner = new Scanner(System.in);
	}

	public String readLine() {
		return scanner.nextLine();
	}
}
