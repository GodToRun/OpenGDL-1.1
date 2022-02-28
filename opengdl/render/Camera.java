package opengdl.render;

import org.lwjgl.opengl.GL11;

import opengdl.core.GDLObject;
import vecutils.Vector3;

public class Camera extends GDLObject {
	public static Camera instance = new Camera();
	
	public Camera() {
		super(null);
	}
	
	public void lookThrough()
	{
	//roatate the pitch around the position.x aposition.xis
		GL11.glRotatef(rotation.y, 1.0f, 0.0f, 0.0f);
	//roatate the yaw around the Y aposition.xis
		GL11.glRotatef(rotation.z, 0.0f, 1.0f, 0.0f);
	//translate to the  vector's location
		GL11.glTranslatef(position.x, -position.y, position.z);
	}
	@Override
	public void move(Vector3 vec) {
		if (vec.x > 0) {
			strafeRight(vec.x);
		}
		else if (vec.x < 0) {
			strafeLeft(-vec.x);
		}
		
		if (vec.z > 0) {
			walkForward(vec.z);
		}
		else if (vec.z < 0) {
			walkBackwards(-vec.z);
		}
		position.y += vec.y;
	}
	private void walkForward(float distance)
	{
		position.x -= distance * (float)Math.sin(Math.toRadians(rotation.z));
		position.z += distance * (float)Math.cos(Math.toRadians(rotation.z));
	}
	//moves the camera backward relitive to its current rotation (yaw)
	private void walkBackwards(float distance)
	{
		position.x += distance * (float)Math.sin(Math.toRadians(rotation.z));
		position.z -= distance * (float)Math.cos(Math.toRadians(rotation.z));
	}
	
	public void yaw(float amount)
	{
		//increment the yaw by the amount param
		rotation.z += amount;
	}

	//increment the camera's current yaw rotation
	public void pitch(float amount)
	{
		if (rotation.y > 90) {
			rotation.y = 90;
		}
		if (rotation.y < -90) {
			rotation.y = -90;
		}
		//increment the pitch by the amount param
		rotation.y += amount;
	}
	
	//strafes the camera left relitive to its current rotation (yaw)
	public void strafeLeft(float distance)
	{
		position.x -= distance * (float)Math.sin(Math.toRadians(rotation.z-90));
		position.z += distance * (float)Math.cos(Math.toRadians(rotation.z-90));
	}

	//strafes the camera right relitive to its current rotation (yaw)
	public void strafeRight(float distance)
	{
		position.x -= distance * (float)Math.sin(Math.toRadians(rotation.z+90));
		position.z += distance * (float)Math.cos(Math.toRadians(rotation.z+90));
	}
		
}
