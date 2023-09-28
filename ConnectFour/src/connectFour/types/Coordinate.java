package connectFour.types;

public class Coordinate {
	Integer row;
	Integer column;

	public Coordinate(Integer row, Integer column) {
		this.row = row;
		this.column = column;
	}

	public Integer getRow() {
		return row;
	}

	public Integer getColumn() {
		return column;
	}

	public void displaceCoordinate(Coordinate coordinate) {
		this.row = this.row + coordinate.getRow();
		this.column = this.column + coordinate.getColumn();
	}
	
	public boolean isInsideBoard(Integer rowBoardSize, Integer columnBoardSize) {
		return (this.row >= 0 && this.row < rowBoardSize)
				&& (this.column >= 0 && this.column < columnBoardSize);
	}
}
