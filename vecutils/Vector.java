package vecutils;

public abstract class Vector {
	public float x, y, z, t;
	public abstract void add(Vector b);
	public abstract void sub(Vector b);
	public abstract void mul(Vector b);
	public abstract void div(Vector b);
	public abstract Vector distance(Vector b);
}
