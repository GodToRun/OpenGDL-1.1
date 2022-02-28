package opengdl.example;

import org.lwjgl.opengl.GL11;

import opengdl.core.Mesh;
import vecutils.Vector2;
import vecutils.Vector3;
import vecutils.Vector4;

public class WoodMesh extends Mesh {
	public static WoodMesh instance = new WoodMesh();
	public WoodMesh() {
		super(GL11.GL_QUADS);
		vertices = new Vector3[40];
		vertices[0] = new Vector3(1f, 1f, 1f);
		vertices[1] = new Vector3(0f, 1f, 1f);
		vertices[2] = new Vector3(0f, -1f, 1f);
		vertices[3] = new Vector3(1f, -1f, 1f);
		
		vertices[4] = new Vector3(1f, 1f, -1f);
		vertices[5] = new Vector3(0f, 1f, -1f);
		vertices[6] = new Vector3(0f, -1f, -1f);
		vertices[7] = new Vector3(1f, -1f, -1f);
		
		vertices[8] = new Vector3(0f, 1f, -1f);
		vertices[9] = new Vector3(-0.4f, 1f, -0.6f);
		vertices[10] = new Vector3(-0.4f, -1f, -0.6f);
		vertices[11] = new Vector3(0f, -1f, -1f);
		
		vertices[12] = new Vector3(1f, 1f, -1f);
		vertices[13] = new Vector3(1.4f, 1f, -0.6f);
		vertices[14] = new Vector3(1.4f, -1f, -0.6f);
		vertices[15] = new Vector3(1f, -1f, -1f);
		
		vertices[16] = new Vector3(1.4f, 1f, -0.6f);
		vertices[17] = new Vector3(1.8f, 1f, 0f);
		vertices[18] = new Vector3(1.8f, -1f, 0f);
		vertices[19] = new Vector3(1.4f, -1f, -0.6f);
		
		vertices[20] = new Vector3(1.8f, 1f, 0f);
		vertices[21] = new Vector3(1.6f, 1f, 0.6f);
		vertices[22] = new Vector3(1.6f, -1f, 0.6f);
		vertices[23] = new Vector3(1.8f, -1f, 0f);
		
		vertices[24] = new Vector3(1.6f, 1f, 0.6f);
		vertices[25] = new Vector3(1f, 1f, 1f);
		vertices[26] = new Vector3(1f, -1f, 1f);
		vertices[27] = new Vector3(1.6f, -1f, 0.6f);
		
		vertices[28] = new Vector3(-0.4f, 1f, -0.6f);
		vertices[29] = new Vector3(-0.6f, 1f, -0.1f);
		vertices[30] = new Vector3(-0.6f, -1f, -0.1f);
		vertices[31] = new Vector3(-0.4f, -1f, -0.6f);
		
		vertices[32] = new Vector3(-0.6f, 1f, -0.1f);
		vertices[33] = new Vector3(-0.4f, 1f, 0.4f);
		vertices[34] = new Vector3(-0.4f, -1f, 0.4f);
		vertices[35] = new Vector3(-0.6f, -1f, -0.1f);
		
		vertices[36] = new Vector3(-0.4f, 1f, 0.4f);
		vertices[37] = new Vector3(0f, 1f, 1f);
		vertices[38] = new Vector3(0f, -1f, 1f);
		vertices[39] = new Vector3(-0.4f, -1f, 0.4f);
		
		colors = new Vector4[1];
		colors[0] = new Vector4(1f, 1f, 1f, 1f);
		uvs = new Vector2[40];
		for (int i = 0; i < uvs.length; i++) {
			uvs[i] = new Vector2(vertices[i].x, vertices[i].y);
		}
	}
}
