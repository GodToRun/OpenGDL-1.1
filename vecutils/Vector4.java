package vecutils;

public class Vector4 extends Vector3 {
	public static Vector4 ZERO() { return new Vector4(0, 0, 0, 0); }
	public static Vector4 RIGHT() { return new Vector4(1, 0, 0, 0); }
	public static Vector4 FORWARD() { return new Vector4(0, 0, 1, 0); }
	public static Vector4 ONE() { return new Vector4(1, 1, 1, 1); }
	public Vector4(float x, float y, float z, float t) {
		super(x, y, z);
		this.t = t;
	}
	
	@Override
	public void add(Vector b) {
		super.add(b);
		this.t += b.t;
	}

	@Override
	public void sub(Vector b) {
		super.sub(b);
		this.t -= b.t;
	}

	@Override
	public void mul(Vector b) {
		super.mul(b);
		this.t *= b.t;
	}

	@Override
	public void div(Vector b) {
		super.div(b);
		this.t /= b.t;
	}

	@Override
	public Vector4 distance(Vector b) {
		return new Vector4(Math.abs(x - b.x), Math.abs(y - b.y), Math.abs(z - b.z), Math.abs(t - b.t));
	}
}
