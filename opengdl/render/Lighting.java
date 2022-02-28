package opengdl.render;

import static org.lwjgl.opengl.GL11.GL_AMBIENT_AND_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_COLOR_MATERIAL;
import static org.lwjgl.opengl.GL11.GL_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_FRONT;
import static org.lwjgl.opengl.GL11.GL_LIGHT0;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_LIGHT_MODEL_AMBIENT;
import static org.lwjgl.opengl.GL11.GL_POSITION;
import static org.lwjgl.opengl.GL11.GL_SHININESS;
import static org.lwjgl.opengl.GL11.GL_SMOOTH;
import static org.lwjgl.opengl.GL11.GL_SPECULAR;
import static org.lwjgl.opengl.GL11.glColorMaterial;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLight;
import static org.lwjgl.opengl.GL11.glLightModel;
import static org.lwjgl.opengl.GL11.glMaterial;
import static org.lwjgl.opengl.GL11.glMaterialf;
import static org.lwjgl.opengl.GL11.glShadeModel;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

import vecutils.Vector4;

public class Lighting {
	static FloatBuffer matSpecular;
	static FloatBuffer lightPosition;
	static FloatBuffer whiteLight;
	static FloatBuffer lModelAmbient;
	
	public static void initialize(Vector4 lightingColor) {
		matSpecular = BufferUtils.createFloatBuffer(4);
        matSpecular.put(1.0f).put(1.0f).put(1.0f).put(1.0f).flip();
 
        lightPosition = BufferUtils.createFloatBuffer(4);
        lightPosition.put(5).put(60.0f).put(5).put(0.0f).flip();
         
        whiteLight = BufferUtils.createFloatBuffer(4);
        whiteLight.put(lightingColor.x).put(lightingColor.y).put(lightingColor.z).put(lightingColor.t).flip();
         
        lModelAmbient = BufferUtils.createFloatBuffer(4);
        lModelAmbient.put(0.3f).put(0.3f).put(0.3f).put(5.0f).flip();
        
        glShadeModel(GL_SMOOTH);
        glMaterial(GL_FRONT, GL_SPECULAR, matSpecular);             // sets specular material color
        glMaterialf(GL_FRONT, GL_SHININESS, 50.0f);                 // sets shininess
         
        glLight(GL_LIGHT0, GL_POSITION, lightPosition);             // sets light position
        glLight(GL_LIGHT0, GL_SPECULAR, whiteLight);                // sets specular light to white
        glLight(GL_LIGHT0, GL_DIFFUSE, whiteLight);                 // sets diffuse light to white
        glLightModel(GL_LIGHT_MODEL_AMBIENT, lModelAmbient);        // global ambient light
        
        glEnable(GL_LIGHTING);                                      // enables lighting
        glEnable(GL_LIGHT0);                                        // enables light0
         
        glEnable(GL_COLOR_MATERIAL);                                // enables opengl to use glColor3f to define material color
        glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
	}
}
