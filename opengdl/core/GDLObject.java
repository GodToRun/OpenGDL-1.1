package opengdl.core;

import java.nio.FloatBuffer;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

import opengdl.shader.Shader;
import vecutils.Vector2;
import vecutils.Vector3;
import vecutils.Vector4;

public class GDLObject {
	public int vbo_vertex_handle;
	public int vbo_color_handle;
	public int vbo_tex_handle;
	public int vertices = 3;

	public int vertex_size = 3; // X, Y, Z
	public int color_size = 4; // R, G, B, A
	public int tex_size = 2; // X, Y
	public RenderMode renderMode = RenderMode.Immediate;
	protected Vector3 position = Vector3.ZERO();
	protected Vector4 rotation = new Vector4(0.0f, 0.0f, 0.0f, 0.0f);
	protected Vector3 scale = new Vector3(1, 1, 1);
	public Texture texture;
	private Shader shader = new Shader();
	public static ArrayList<GDLObject> objects = new ArrayList<GDLObject>();
	public Mesh mesh;
	public GDLObject(Mesh mesh) {
		this.mesh = mesh;
		objects.add(this);
	}
	public void createVBOBuffer() {
		vertices = mesh.vertices.length;
		//vertex_size = 

		FloatBuffer vertex_data = BufferUtils.createFloatBuffer(vertices * vertex_size);
		for (Vector3 vertex : mesh.vertices) {
			vertex_data.put(new float[] { vertex.x, vertex.y, vertex.z });
		}
		vertex_data.flip();

		FloatBuffer color_data = BufferUtils.createFloatBuffer(vertices * color_size);
		if (mesh.colors.length == 1) {
			for (int i = 0; i < mesh.vertices.length; i++) {
				color_data.put(new float[] { mesh.colors[0].x, mesh.colors[0].y, mesh.colors[0].z, mesh.colors[0].t });
			}
		}
		else {
			for (Vector4 color : mesh.colors) {
				color_data.put(new float[] { color.x, color.y, color.z, color.t });
			}
		}
		FloatBuffer tex_data = BufferUtils.createFloatBuffer(vertices * tex_size);
		for (Vector2 uv : mesh.uvs) {
			tex_data.put(new float[] { uv.x, uv.y });
		}
		tex_data.flip();
		color_data.flip();

		vbo_vertex_handle = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo_vertex_handle);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertex_data, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

		vbo_color_handle = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo_color_handle);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, color_data, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		
		vbo_tex_handle = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo_tex_handle);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, tex_data, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
	}
	public void move(Vector3 vec) {
		this.position.add(vec);
	}
	public void setPosition(Vector3 vec) {
		this.position = vec;
	}
	public Vector3 getPosition() {
		return this.position;
	}
	public void setScale(Vector3 vec) {
		this.scale = vec;
	}
	public Vector3 getScale() {
		return this.scale;
	}
	public Shader getShader() {
		return this.shader;
	}
	public void setRotation(Vector4 roc) {
		this.rotation = roc;
	}
	public Vector4 getRotation() {
		return this.rotation;
	}
	public void setShaderTransparent(boolean bool) {
		this.shader.renderTransparent = bool;
	}
}
