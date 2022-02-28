package opengdl.core;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import opengdl.display.GameDisplay;

public class OpenGDL {
	public static void MakeLWJGLContext() {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glClearDepth(1.0); 
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL); 

        GL11.glMatrixMode(GL11.GL_PROJECTION); 
        GL11.glLoadIdentity();

        
        GLU.gluPerspective(
          45.0f,
          (float)GameDisplay.getWidth()/(float)      GameDisplay.getHeight(),
          0.1f,
          500.0f);

        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
        
    }
}
