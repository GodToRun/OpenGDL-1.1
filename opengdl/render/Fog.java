package opengdl.render;

import static org.lwjgl.opengl.GL11.GL_DONT_CARE;
import static org.lwjgl.opengl.GL11.GL_EXP;
import static org.lwjgl.opengl.GL11.GL_FOG;
import static org.lwjgl.opengl.GL11.GL_FOG_COLOR;
import static org.lwjgl.opengl.GL11.GL_FOG_DENSITY;
import static org.lwjgl.opengl.GL11.GL_FOG_END;
import static org.lwjgl.opengl.GL11.GL_FOG_HINT;
import static org.lwjgl.opengl.GL11.GL_FOG_MODE;
import static org.lwjgl.opengl.GL11.GL_FOG_START;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glFog;
import static org.lwjgl.opengl.GL11.glFogf;
import static org.lwjgl.opengl.GL11.glFogi;
import static org.lwjgl.opengl.GL11.glHint;
import static org.lwjgl.opengl.GL11.glDisable;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

import vecutils.Vector4;

public class Fog {
	public static void initialize(Vector4 fogColor, float density, float start, float end) {
		FloatBuffer fogcolor = BufferUtils.createFloatBuffer(4);
		fogcolor.put(fogColor.x).put(fogColor.y).put(fogColor.z).put(fogColor.t).flip();
		glFogi(GL_FOG_MODE, GL_EXP);
		glFog(GL_FOG_COLOR, fogcolor);           
		// Enable Light One
		glFogf(GL_FOG_DENSITY, 0.04f);
		// How Dense Will The Fog Be
		glHint(GL_FOG_HINT, GL_DONT_CARE);
		// Fog Hint Value
		glFogf(GL_FOG_START, 3f);
		// Fog Start Depth
		glFogf(GL_FOG_END, 6f); 
		// Fog End Depth
		glEnable(GL_FOG);
	}
	public static void disable() {
		glDisable(GL_FOG);
	}
}
