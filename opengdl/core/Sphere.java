package opengdl.core;

import org.lwjgl.opengl.GL11;

import opengdl.core.Mesh;
import opengdl.render.Camera;
import opengdl.shader.Shader;
import vecutils.Vector2;
import vecutils.Vector3;
import vecutils.Vector4;

public class Sphere extends Mesh {
	org.lwjgl.util.glu.Sphere sphere = new org.lwjgl.util.glu.Sphere();
	public Sphere() {
		super(GL11.GL_QUADS);
		colors = new Vector4[1];
		colors[0] = new Vector4(1, 1, 1, 1);
	}
	@Override
	public void render(Vector3 pos, Vector3 scale, Vector4 rotation, Texture tex, Shader shader, boolean renderInSpace) {
		if (renderInSpace)
			Camera.instance.lookThrough();
		GL11.glTranslatef(pos.x, -pos.y, pos.z);
		GL11.glColor4f(colors[0].x, colors[0].y, colors[0].z, colors[0].t);
		sphere.draw(scale.y, 8, 8);
		GL11.glEnd();
	}
}
