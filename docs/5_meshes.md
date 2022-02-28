# Meshes
# Cube
delete color code and change object generate code to this.
```java
GDLObject obj = new GDLObject(Mesh.cube);
```
then you got a 3d six-sided quad!
# Sphere
Mesh.sphere
# Terrain
terrain is height-map mesh.
```java
GDLObject obj = new GDLObject(Mesh.terrain);
```
height-map image is res/opengdl/heightmap.png.<br>
if you want a advanced terrain height map, change Mesh.terrain to 
new Terrain("image file name").
