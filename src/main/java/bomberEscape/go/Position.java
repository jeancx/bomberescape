package bomberEscape.go;

public final class Position {
	private final int	x;
	private final int	y;

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Position north(int speed) {
		return new Position(x, y - speed);
	}

	public Position south(int speed) {
		return new Position(x, y + speed);
	}

	public Position west(int speed) {
		return new Position(x + speed, y);
	}

	public Position east(int speed) {
		return new Position(x - speed, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Position other = (Position) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}

}
