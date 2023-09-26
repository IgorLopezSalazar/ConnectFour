package connectFour.types;

public class Goal {

	private Coordinate[] coordinates;
	Direction direction;

	public static final Integer CONNECTED_TOKEN_GOAL = 4;

	public Goal(Coordinate startCoordinate, Direction direction) {
		this.direction = direction;
		coordinates[0] = startCoordinate;
		Coordinate vectorial = direction.getVectorialDirection();
		for (int i = 1; i < CONNECTED_TOKEN_GOAL; i++) {
			coordinates[i] = new Coordinate(coordinates[i - 1].getRow() + vectorial.getRow(),
					coordinates[i - 1].getColumn() + vectorial.getColumn());
		}
	}
	
	public Coordinate[] getCoordinates() {
		return coordinates;
	}
	
	public void iterateCoordinates() {
		Coordinate inverse = direction.getInverseVectorial();
		for(Coordinate coordinate : coordinates) {
			coordinate.displaceCoordinate(inverse);
		}
	}
}
