package vecutils;

public class Vector2 extends Vector {
	public static Vector2 ZERO() { return new Vector2(0, 0); }
	public static Vector2 ONE() { return new Vector2(1, 1); }
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void add(Vector b) {
		this.x += b.x;
		this.y += b.y;
	}

	@Override
	public void sub(Vector b) {
		this.x -= b.x;
		this.y -= b.y;
	}

	@Override
	public void mul(Vector b) {
		this.x *= b.x;
		this.y *= b.y;
	}

	@Override
	public void div(Vector b) {
		this.x /= b.x;
		this.y /= b.y;
	}

	@Override
	public Vector2 distance(Vector b) {
		return new Vector2(Math.abs(x - b.x), Math.abs(y - b.y));
	}
}
