package opengdl.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.GL11;

import vecutils.Vector3;
import vecutils.Vector4;

public class Terrain extends Mesh {
	public int w = 200, h = 300;
	public BufferedImage image;
	float[][] heightmap = new float[w+1][h+1];
	ArrayList<Vector3> verticesList = new ArrayList<Vector3>();
	float getHeightMap(int x, int z) {
		if (x < 0 || z < 0 || x >= w || z >= h) {
			return 0;
		}
		else {
				return heightmap[x][z];
		}
	}
	public Terrain(String heightMapFile) {
		super(GL11.GL_TRIANGLE_STRIP);
		try {
			if (heightMapFile != null)
				image = ImageIO.read(new File(heightMapFile));
			else
				image = ImageIO.read(new File("res/opengdl/heightmap.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		float scale = 4;
		float noise = 6.5f;
		for (int x = 0; x < w; x++) {
			for (int z = 0; z < h; z++) {
				float r = image.getRGB((int)(x * noise), (int)(z * noise)) >> 16 & 0xff;
				float g = image.getRGB((int)(x * noise), (int)(z * noise)) >> 8 & 0xff;
				float b = image.getRGB((int)(x * noise), (int)(z * noise)) & 0xff;
				float value = ((r + g + b) / 3 / 50) * scale;
				heightmap[x][z] = value;
			}
		}
		int i = 0;
		float rx = 0, rz = 0;
		for (int x = 0; x < w; x++) {
			for (int z = 0; z < h; z++) {
				verticesList.add(new Vector3(x, getHeightMap(x, z), z));
				verticesList.add(new Vector3(x+1, getHeightMap(x+1, z+1), z+1));
				verticesList.add(new Vector3(x, getHeightMap(x, z+1), z+1));
				verticesList.add(new Vector3(x+1, getHeightMap(x+1, z), z));
				
				verticesList.add(new Vector3(x+1, getHeightMap(x+1, z+1), z+1));
				i++;
				rz += 2;
			}
			rx += 2;
			rz = 0;
		}
		colors = new Vector4[1];
		colors[0] = new Vector4(1, 1, 1, 1);
		vertices = (Vector3[]) verticesList.toArray(new Vector3[verticesList.size()]);
		uvs = vertices;
	}
}
