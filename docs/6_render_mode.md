# Render Mode

# Immediate Mode
tell the GPU each vertex. low performance but very simple.
```java
obj.renderMode = RenderMode.Immediate;
```
# Array Mode
tell the GPU all vertices at once.
```java
obj.renderMode = RenderMode.Array;
```
you need to create vbo buffer after initialize LWJGL Context.
```java
obj.createVBOBuffer();
```
then you got a very good performance!
