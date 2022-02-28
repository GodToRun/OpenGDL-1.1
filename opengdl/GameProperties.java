package opengdl;
import java.util.*;

public class GameProperties {
	private static HashMap<String, Object> hashMap = new HashMap<String, Object>();
	public static void setAttribute(String key, Object value) {
		hashMap.put(key, value);
	}
	public static Object getAttribute(String key) {
		return hashMap.get(key);
	}
}
