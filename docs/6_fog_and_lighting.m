# Fog And Lighting
# Lighting
You can use Lighting in OpenGDL.
initialize Lighting after Made LWJGL Context.
```java
//White Light
Lighting.initialize(Vector4.ONE());
```
# Fog
Also You can use Fog in OpenGDL.
initialize Lighting after Made LWJGL Context.
```java
Fog.initialize(Vector4.ZERO() /* Fog Color */, /* Fog Density */ 0.01f, 3 /* Start */, 6 /* End */);
```
