package opengdl.example;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import opengdl.core.Cube;
import opengdl.core.GDLObject;
import opengdl.core.Mesh;
import opengdl.core.OpenGDL;
import opengdl.core.Quad;
import opengdl.core.RenderMode;
import opengdl.core.Sphere;
import opengdl.core.Texture;
import opengdl.core.Textures;
import opengdl.display.GameDisplay;
import opengdl.render.*;
import opengdl.sync.Time;
import vecutils.Vector3;
import vecutils.Vector4;
import org.lwjgl.BufferUtils;
public class Example {
	GDLObject ground = new GDLObject(Mesh.terrain);
	GDLObject water = new GDLObject(new Cube());
	boolean fog = true;
	void generateTree(int x, int y, int z) {
		GDLObject tree = new GDLObject(WoodMesh.instance);
		GDLObject branch1 = new GDLObject(WoodMesh.instance);
		GDLObject branch2 = new GDLObject(WoodMesh.instance);
		GDLObject branch3 = new GDLObject(WoodMesh.instance);
		GDLObject leave1 = new GDLObject(new Sphere());
		GDLObject leave2 = new GDLObject(new Sphere());
		GDLObject leave3 = new GDLObject(new Sphere());
		
		leave1.mesh.colors[0] = new Vector4(0, 0.9f, 0, 1);
		leave2.mesh.colors[0] = new Vector4(0, 0.7f, 0, 1);
		leave3.mesh.colors[0] = new Vector4(0, 0.7f, 0.4f, 1);
		Texture woodPNG = Textures.loadTexture("res/opengdl/terrainAdventure/woodtexture.jpg", 9728);
		tree.texture = woodPNG;
		branch1.texture = woodPNG;
		branch2.texture = woodPNG;
		branch3.texture = woodPNG;
		tree.move(new Vector3(x, y+6, z));
		branch1.setRotation(new Vector4(45, 0, 0, -52));
		branch1.move(new Vector3(x + 0.3f, y - 1f, z - 2));
		branch1.setScale(new Vector3(0.5f, 2f, 0.5f));
		
		branch2.setRotation(new Vector4(45, 0, 30, 40));
		branch2.move(new Vector3(x - 0.2f, y - 1f, z + 2));
		branch2.setScale(new Vector3(0.5f, 2f, 0.5f));
		
		branch3.setRotation(new Vector4(45, -20, 260, 60));
		branch3.move(new Vector3(x - 2f, y - 1f, z - 0.5f));
		branch3.setScale(new Vector3(0.5f, 2f, 0.5f));
		
		leave1.move(new Vector3(x - 2, y - 4f, z + 3f));
		leave1.setScale(new Vector3(1, 2.5f, 1));
		
		leave2.move(new Vector3(x + 2, y - 3, z - 3.5f));
		leave2.setScale(new Vector3(1, 2.5f, 1));
		
		leave3.move(new Vector3(x - 4f, y - 2.5f, z -2f));
		leave3.setScale(new Vector3(1, 2.5f, 1));
		
		tree.setScale(new Vector3(1, 6, 1));
	}

	public Example() {
		
		Mouse.setGrabbed(true);
		Camera.instance.move(new Vector3(300, 0, 400));
		water.setScale(new Vector3(200, 3, 300));
		water.move(new Vector3(200, 0, -500));
		water.getShader().alphaRenderMode = GL11.GL_BLEND;
		water.setShaderTransparent(true);
		water.mesh.colors[0] = new Vector4(0, 0, 1, 0.4f);
		ground.move(new Vector3(200, 3, -500));
		
		//ground.setScale(new Vector3(100, 1, 100));
		Random random = new Random();
		
		
		//quad2.move(new Vector3(0, 0, 2));
		GameDisplay.setTitle("Example");
		try {
			GameDisplay.create(720, 480);
		} catch (Exception e) {
			e.printStackTrace();
		}
		OpenGDL.MakeLWJGLContext();
		//White light
		Lighting.initialize(Vector4.ONE());
		
		// Enables GL_FOG
		Fog.initialize(new Vector4(0.5f, 0.5f, 0.5f, 1), 0.03f, 3f, 6f);
		
		ground.renderMode = RenderMode.Array;
		ground.createVBOBuffer();
		for (int i = 0; i < 50; i++) {
			int x = 200 + random.nextInt(200);
			int y = -11;
			int z = 300 + random.nextInt(200);
			generateTree(x, y, -z);
		}
		Texture texture = Textures.loadTexture("res/opengdl/terrainAdventure/grassImage.png", 9728);
		for (int i = 0; i < 180; i++) {
			GDLObject grass = new GDLObject(Mesh.quad);
			grass.setShaderTransparent(true);
			grass.texture = texture;
			float x = 200 + random.nextInt(200);
			float y = -2;
			float z = 300 + random.nextInt(200);
			grass.move(new Vector3(x, y, -z));
		}
		ground.texture = Textures.loadTexture("res/opengdl/terrainAdventure/lwjglterrain.jpg", 9728);
		GameRenderer.setBackground(new Vector4(0.5f, 0.5f, 0.5f, 1));
		run();
	}
	private void run() {
		while (!GameDisplay.isHalted()) {
			if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				Camera.instance.move(new Vector3(0, 0, Time.getDeltaTime() * 10));
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				Camera.instance.move(new Vector3(0, 0, Time.getDeltaTime() * -10));
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				Camera.instance.move(new Vector3(Time.getDeltaTime() * 10, 0, 0));
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				Camera.instance.move(new Vector3(Time.getDeltaTime() * -10, 0, 0));
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				Camera.instance.move(new Vector3(0, Time.getDeltaTime() * 10, 0));
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				Camera.instance.move(new Vector3(0, Time.getDeltaTime() * -10, 0));
			}
			while (Keyboard.next()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_F) {
					fog = !fog;
					if (fog) {
						GameRenderer.setBackground(new Vector4(0.5f, 0.5f, 0.5f, 1));
						Fog.initialize(new Vector4(0.5f, 0.5f, 0.5f, 1), 0.03f, 3, 6);
					}
					else {
						GameRenderer.setBackground(new Vector4(0f, 0.8f, 1f, 1));
						Fog.disable();
					}
				}
			}
			Camera.instance.yaw(Mouse.getDX());
			Camera.instance.pitch(-Mouse.getDY());
			
			GameRenderer.render();
			Time.update();
			GameDisplay.update();
		}
		GameDisplay.destroy();
	}
	public static void main(String[] args) {
		new Example();
	}

}
