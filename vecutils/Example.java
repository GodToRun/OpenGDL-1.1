package vecutils;

public class Example {

	public static void main(String[] args) {
		Vector2 vec2 = new Vector2(1, 2);
		Vector2 vec2b = new Vector2(3, 9);
		Vector3 vec3 = new Vector3(3, 0, 7);
		Vector3 vec3b = new Vector3(2, 25, 14);
		Vector4 vec4 = new Vector4(2, 13, 5, 9);
		Vector4 vec4b = new Vector4(4, 7, 15, 48);
		System.out.println("========== Vector2 ==========");
		System.out.println("A Vector X " + vec2.x + " Y " + vec2.y);
		System.out.println("B Vector X " + vec2b.x + " Y " + vec2b.y);
		System.out.println();
		vec2.add(vec2b);
		System.out.println("Add Result " + vec2.x + " Y " + vec2.y);
		
		System.out.println("========== Vector3 ==========");
		System.out.println("A Vector X " + vec3.x + " Y " + vec3.y + " Z " + vec3.z);
		System.out.println("B Vector X " + vec3b.x + " Y " + vec3b.y + " Z " + vec3b.z);
		System.out.println();
		vec3.mul(vec3b);
		System.out.println("MUL Result " + vec3.x + " Y " + vec3.y + " Z " + vec3.z);
		
		System.out.println("========== Vector4 ==========");
		System.out.println("A Vector X " + vec4.x + " Y " + vec4.y + " Z " + vec4.z + " T " + vec4.t);
		System.out.println("A Vector X " + vec4b.x + " Y " + vec4b.y + " Z " + vec4b.z + " T " + vec4b.t);
		System.out.println();
		vec4.sub(vec4b);
		System.out.println("Sub Result " + vec4.x + " Y " + vec4.y + " Z " + vec4.z + " T " + vec4.t);
	}

}
