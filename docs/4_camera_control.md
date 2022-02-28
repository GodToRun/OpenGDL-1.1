# Camera Control
# Camera rotate
you need to use lwjgl's mouse class because opengdl not supporting io in 1.0.<br>
lock mouse cursor
```java
Mouse.setGrabbed(true);
```
and turn camera in loop method
```java
Camera.instance.yaw(Mouse.getDX());
Camera.instance.pitch(-Mouse.getDY());
```
then you can rotate around!
# Delta time
Delta time is 1 / fps, 
Compensates the calculation speed with the drawing speed.<br>
i don't recommend v-sync. use <strong>Delta Time</strong> instead v-sync.
# Camera movement
you need to use lwjgl's keyboard utility class.<br>
inject this code to loop method.
```java
if (Keyboard.isKeyDown(Keyboard.KEY_W))
  Camera.instance.move(new Vector3(0, 0, 4 * Time.getDeltaTime()));
if (Keyboard.isKeyDown(Keyboard.KEY_S))
  Camera.instance.move(new Vector3(0, 0, -4 * Time.getDeltaTime()));
if (Keyboard.isKeyDown(Keyboard.KEY_A))
  Camera.instance.move(new Vector3(-4 * Time.getDeltaTime(), 0, 0));
if (Keyboard.isKeyDown(Keyboard.KEY_D))
  Camera.instance.move(new Vector3(4 * Time.getDeltaTime(), 0, 0));
if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
  Camera.instance.move(new Vector3(0, 4 * Time.getDeltaTime(), 0));
if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
  Camera.instance.move(new Vector3(0, -4 * Time.getDeltaTime(), 0));
```
then, you can move round!
