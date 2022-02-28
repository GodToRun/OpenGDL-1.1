package bufferutils;

public class BooleanBuffer extends Buffer {
	private boolean[] buf;
	public BooleanBuffer(int size) {
		buf = new boolean[size];
	}
	public boolean get(int i) {
		return buf[i];
	}
	public void set(int i, boolean value) {
		this.buf[i] = value;
	}
	public void set(boolean value) {
		set(0, value);
	}
	public boolean get() {
		return get(0);
	}
}
