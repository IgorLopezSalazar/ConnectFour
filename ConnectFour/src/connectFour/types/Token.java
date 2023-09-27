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
}
