package bufferutils;

public class WordBuffer extends Buffer {
	private short[] buf;
	public WordBuffer(int size) {
		buf = new short[size];
	}
	public short get(int i) {
		return buf[i];
	}
	public void set(int i, short value) {
		this.buf[i] = value;
	}
	public void set(short value) {
		set(0, value);
	}
	public short get() {
		return get(0);
	}
}
