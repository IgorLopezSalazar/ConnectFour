package connectFour.types;

public class Line {

	private Coordinate[] coordinates;
	Direction direction;

	public static final Integer CONNECTED_TOKEN_LINE = 4;

	public Line(Coordinate startCoordinate, Direction direction) {
		this.direction = direction;
		this.coordinates = new Coordinate[CONNECTED_TOKEN_LINE];
		coordinates[0] = startCoordinate;
		Coordinate vectorial = direction.getVectorialDirection();
		for (int i = 1; i < CONNECTED_TOKEN_LINE; i++) {
			coordinates[i] = new Coordinate(coordinates[i - 1].getRow() + vectorial.getRow(),
					coordinates[i - 1].getColumn() + vectorial.getColumn());
		}
	}

	public Coordinate[] getCoordinates() {
		return coordinates;
	}

	public void iterateCoordinates() {
		Coordinate inverse = direction.getInverseVectorial();
		for (Coordinate coordinate : coordinates) {
			coordinate.displaceCoordinate(inverse);
		}
	}
}
