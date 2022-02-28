package vecutils;

public class Vector3 extends Vector2 {
	public static Vector3 ZERO() { return new Vector3(0, 0, 0); }
	public static Vector3 RIGHT() { return new Vector3(1, 0, 0); }
	public static Vector3 FORWARD() { return new Vector3(0, 0, 1); }
	public static Vector3 ONE() { return new Vector3(1, 1, 1); }
	public Vector3(float x, float y, float z) {
		super(x, y);
		this.z = z;
	}
	
	@Override
	public void add(Vector b) {
		super.add(b);
		this.z += b.z;
	}

	@Override
	public void sub(Vector b) {
		super.sub(b);
		this.z -= b.z;
	}

	@Override
	public void mul(Vector b) {
		super.mul(b);
		this.z *= b.z;
	}

	@Override
	public void div(Vector b) {
		super.div(b);
		this.z /= b.z;
	}

	@Override
	public Vector3 distance(Vector b) {
		return new Vector3(Math.abs(x - b.x), Math.abs(y - b.y), Math.abs(z - b.z));
	}
}
