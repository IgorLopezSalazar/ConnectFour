package connectFour.types;

public enum Direction {
	NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST;
	
	public Coordinate getVectorialDirection(Direction direction) {
		switch (direction) {
		case NORTH: {
			return new Coordinate(0, 1);
		}
		case NORTHEAST: {
			return new Coordinate(1, 1);
		}
		case EAST: {
			return new Coordinate(1, 0);
		}
		case SOUTHEAST: {
			return new Coordinate(1, -1);
		}
		case SOUTH: {
			return new Coordinate(0, -1);
		}
		case SOUTHWEST: {
			return new Coordinate(-1, -1);
		}
		case WEST: {
			return new Coordinate(-1, 0);
		}
		case NORTHWEST: {
			return new Coordinate(-1, 1);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + direction);
		}
	}
}
