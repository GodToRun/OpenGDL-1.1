# First GDL Object
first, you need to define gdl object.
```java
GDLObject obj = new GDLObject(new Quad());
```
and move camera to backward.<br>
```java
Camera.instance.move(new Vector3(0, 0, -7));
```
then you got a quad!
