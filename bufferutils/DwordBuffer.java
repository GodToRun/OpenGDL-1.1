package bufferutils;

public class DwordBuffer extends Buffer {
	private int[] buf;
	public DwordBuffer(int size) {
		buf = new int[size];
	}
	public int get(int i) {
		return buf[i];
	}
	public void set(int i, int value) {
		this.buf[i] = value;
	}
	public void set(int value) {
		set(0, value);
	}
	public int get() {
		return get(0);
	}
}
