### Initializing OpenGL

The *GLSurfaceView* class is used to initialize OpenGL and is reponsible for

* Configuring the display
* Rendering on a background thread on an area of the screen known as a *surface/viewport* 
* Offering helper methods to handle Android's Activity life cycle.

### Creating a renderer

Create a new renderer "CustomRenderer" that implements the *GLSurfaceView.Renderer* interface.

*BasicOpenGLApp\app\src\main\java\com\gruprog\basicopenglapp\CustomRenderer.java*

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

The parameters *int i* and *int i1* represents the width and the height respectively. 

3) The *onDrawFrame(GL10 gl10)* method is called by *GLSurfaceView* on a separate thread to draw a frame where the drawing MUST take place. 

As the method gets called to draw a SINGLE frame, it gets called many times per second. 

NOTE: The *GL10* parameters in the above methods are used ONLY for OpenGL ES 1.0 renderer. An OpenGL ES 2.0 renderer uses the static methods of the *GLES20* class.

**Clearing the screen**

*BasicOpenGLApp\app\src\main\java\com\gruprog\basicopenglapp\CustomRenderer.java*

```java
package com.gruprog.basicopenglapp;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CustomRenderer implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(0.2f, 0.5f, 1.0f, 0.4f);                ------- 1
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glViewport(0, 0, width, height);                     ------- 2
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);                 ------- 3
    }
}
```

1) Set the clear color by calling the static method *GLES20.glClearColor* with the following arguments

* Strength of RED (R in RGB)
* Strength of BLUE (B in RGB)
* Strength of GREEN (G in RGB)
* Alpha value that represents the level of translucency and transparency

2) Set the viewport size to specify to OpenGL the size of the surface that is available for rendering. Viewport size can be set by calling the static method *GLES20.glViewport*.

3) Clear the screen by calling the static method *GLES20.glClear* to clear out all the colors on the screen and fill the screen with the colors specified in the call to *GLES20.glClearColor* earlier.



