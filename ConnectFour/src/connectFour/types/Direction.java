package connectFour.types;

public enum Direction {
	NORTH, NORTHEAST, EAST, SOUTHEAST;
	
	public Coordinate getVectorialDirection() {
		switch (this) {
		case NORTH: {
			return new Coordinate(1, 0);
		}
		case NORTHEAST: {
			return new Coordinate(1, 1);
		}
		case EAST: {
			return new Coordinate(0, 1);
		}
		case SOUTHEAST: {
			return new Coordinate(-1, 1);
		}
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public Coordinate getInverseVectorial() {
		Coordinate coordinate = this.getVectorialDirection();
		return new Coordinate(-coordinate.getRow(), -coordinate.getColumn());
	}
}
