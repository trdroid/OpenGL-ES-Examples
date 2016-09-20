**Initializing OpenGL**

The *GLSurfaceView* class is used to initialize OpenGL and is reponsible for

* Configuring the display
* Rendering on a background thread on an area of the screen known as a *surface/viewport* 
* Offering helper methods to handle Android's Activity life cycle.

**Creating a renderer**

Create a new renderer "CustomRenderer" that implements the *GLSurfaceView.Renderer* interface.

```java
package com.gruprog.basicopenglapp;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CustomRenderer implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {        ------ 1

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {              ------ 2

    }

    @Override
    public void onDrawFrame(GL10 gl10) {                                  ------ 3
        
    }
}
```

1) The *onSurfaceCreated(GL10 gl10, EGLConfig eglConfig)* method is called by *GLSurfaceView* on a separate thread when the surface is created. 
A surface could be created multiple times during the application's life cycle. A surface is created 

* when the first time the application is run
* when the user switches back to the application
* when the device wakes up

2) The *onSurfaceChanged(GL10 gl10, int i, int i1)* method is called by *GLSurfaceView* on a separate thread AFTER the surface is created and its size has changed.
A size change could happen when

* The screen changes its orientation from portrait to landscape and vice versa

3) The *onDrawFrame(GL10 gl10)* method is called by *GLSurfaceView* on a separate thread to draw a frame where the drawing MUST take place. 

As the method gets called to draw a SINGLE frame, it gets called many times per second. 

NOTE: The *GL10* parameters in the above methods are used ONLY for OpenGL ES 1.0 renderer. An OpenGL ES 2.0 renderer uses the static methods of the *GLES20* class.

