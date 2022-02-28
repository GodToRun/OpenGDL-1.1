# First Display
this doc will create blank window with OpenGDL.<br><br>

Window.java
```java
import opengdl.render.*;
import opengdl.core.OpenGDL;
import opengdl.display.GameDisplay;
import opengdl.sync.Time;
public class Window {

	public Window() {
		GameDisplay.setTitle("First Display");
		try {
			GameDisplay.create(720, 480);
		} catch (Exception e) {
			e.printStackTrace();
		}
		OpenGDL.MakeLWJGLContext();
		run();
	}
	private void run() {
		while (!GameDisplay.isHalted()) {
			
			GameRenderer.render();
			Time.update();
			GameDisplay.update();
		}
		GameDisplay.destroy();
	}
	public static void main(String[] args) {
		new Window();
	}

}

```
