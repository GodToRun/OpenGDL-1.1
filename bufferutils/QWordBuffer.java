package bufferutils;

public class QWordBuffer extends Buffer {
	private long[] buf;
	public QWordBuffer(int size) {
		buf = new long[size];
	}
	public long get(int i) {
		return buf[i];
	}
	public void set(int i, long value) {
		this.buf[i] = value;
	}
	public void set(long value) {
		set(0, value);
	}
	public long get() {
		return get(0);
	}
}
