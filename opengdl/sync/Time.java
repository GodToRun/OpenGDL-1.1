package opengdl.sync;

public class Time {
	private static float DELTA_TIME = 0.01f;
	private static int frames = 0;
	private static long lastTime = System.currentTimeMillis();
	public static void update() {
		 ++frames;
         while (System.currentTimeMillis() >= lastTime + 1000L) {
             System.out.println(String.valueOf(frames) + " fps");
             lastTime += 1000L;
             DELTA_TIME = 1 / (float)frames;
             frames = 0;
         }
	}
	public static int getFramesPerSecond() {
		return frames;
	}
	public static float getDeltaTime() {
		return DELTA_TIME;
	}
}
