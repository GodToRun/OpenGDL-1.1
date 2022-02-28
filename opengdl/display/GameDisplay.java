package opengdl.display;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GameDisplay {
	private static String title = "Open GDL";
	private static DisplayMode displayMode;
	public static void create(int width, int height) throws Exception {
        displayMode = new DisplayMode(width, height);
        Display.setDisplayMode(displayMode);
        Display.setTitle(title);
        Display.create();
   }
	public static void setTitle(String displayName) {
		title = displayName;
	}
	public static int getWidth() {
		return displayMode.getWidth();
	}
	public static int getHeight() {
		return displayMode.getHeight();
	}
	public static boolean isHalted() {
		return Display.isCloseRequested();
	}
	public static void destroy() {
		Display.destroy();
	}
	public static void update() {
		Display.update();
	}
}
