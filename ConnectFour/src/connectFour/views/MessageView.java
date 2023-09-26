package connectFour.views;

public class MessageView {

	void write(Message message) {
		System.out.print(message.toString());
	}

	void writeln(Message message) {
		System.out.println(message.toString());
	}

	void writeln(Message message, String player) {
		assert message == Message.PLAYER_WIN;

		System.out.println(message.toString().replaceAll("#player#", player));
	}
	
}
