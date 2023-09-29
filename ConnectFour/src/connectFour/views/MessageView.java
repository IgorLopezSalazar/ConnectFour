package connectFour.views;

public class MessageView {

	void write(Message message) {
		System.out.print(message.toString());
	}

	void write(String string) {
		System.out.print(string);
	}

	void writeln(Message message) {
		System.out.println(message.toString());
	}

	void writeln(Message message, String token, Integer player) {
		System.out.println(
				message.toString().replaceAll("#player#", String.valueOf(player)).replaceAll("#token#", token));
	}

}
