package opengdl.render;

import org.lwjgl.opengl.GL11;

import opengdl.core.GDLObject;
import opengdl.core.Mesh;
import opengdl.core.RenderMode;
import opengdl.core.Textures;
import opengdl.shader.Shader;
import vecutils.Vector3;
import vecutils.Vector4;

public class GameRenderer {
	public static void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();
		for (GDLObject obj : GDLObject.objects) {
			GL11.glLoadIdentity();
			Vector3 pos = obj.getPosition();
			if (obj.mesh != null) {
				if (obj.renderMode == RenderMode.Immediate)
					obj.mesh.render(pos, obj.getScale(), obj.getRotation(), obj.texture, obj.getShader(), true);
				else if (obj.renderMode == RenderMode.Array)
					obj.mesh.renderVBO(pos, obj.getScale(), obj.getRotation(), obj.vertices, obj.vbo_vertex_handle, obj.vbo_color_handle, obj.vbo_tex_handle, obj.vertex_size, obj.color_size, obj.tex_size, obj.texture, true);
			}
			
		}
	}
	public static void setBackground(Vector4 vec4) {
		GL11.glClearColor(vec4.x, vec4.y, vec4.z, vec4.t);
	}
}
