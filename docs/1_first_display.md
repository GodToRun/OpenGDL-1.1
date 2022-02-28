# First Display
this doc will create blank window with OpenGDL.<br><br>

Window.java
```java
package opengdltest;
import opengdl.render.*;
import opengdl.core.OpenGDL;
import opengdl.display.GameDisplay;
import opengdl.sync.Time;
public class Window {

	public Window() {
		//Display Title
		GameDisplay.setTitle("First Display");
		try {
			GameDisplay.create(720, 480);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//DO NOT FORGOT THIS. VERY VERY IMPORTANT!
		//Do not use any opengl methods before call this method. 
		OpenGDL.MakeLWJGLContext();
		run();
	}
	private void run() {
		//While Display not destroyed
		while (!GameDisplay.isHalted()) {
			//Very important!
			GameRenderer.render();
			Time.update();
			GameDisplay.update();
		}
		//destroy display when halted
		GameDisplay.destroy();
	}
	public static void main(String[] args) {
		new Window();
	}

}
```
