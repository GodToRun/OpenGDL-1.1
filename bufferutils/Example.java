package bufferutils;

public class Example {

	static void foo(DwordBuffer buffer) {
		buffer.set(32);
	}
	public static void main(String[] args) {
		DwordBuffer buffer = new DwordBuffer(2);
		System.out.println("buffer value: " + buffer.get());
		foo(buffer);
		System.out.println("after call foo: " + buffer.get());
	}

}
