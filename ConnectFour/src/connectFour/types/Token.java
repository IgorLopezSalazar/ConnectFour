package connectFour.types;

public enum Token {

	NULL(" "), YELLOW("Y"), RED("R");

	private final String printValue;

	private Token(String printValue) {
		this.printValue = printValue;
	}
	
	public String getPrintValue() {
		return printValue;
	}

	public Token get(Integer index) {
		Token resultToken = null;

		for (Token token : Token.values()) {
			if (token.ordinal() == index) {
				resultToken = token;
			}
		}

		return resultToken;
	}

}
