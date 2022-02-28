package bufferutils;

public class ByteBuffer extends Buffer {
	private byte[] buf;
	public ByteBuffer(int size) {
		buf = new byte[size];
	}
	public byte get(int i) {
		return buf[i];
	}
	public void set(int i, byte value) {
		this.buf[i] = value;
	}
	public void set(byte value) {
		set(0, value);
	}
	public byte get() {
		return get(0);
	}
}
