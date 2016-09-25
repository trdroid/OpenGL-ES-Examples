### Core Animation Compositor

The iOS operating system does not allow programs to write directly into the *front frame buffer* and the *back frame buffer*. 
It alone reserves the control of writing to these buffers by using its component called as **Core Animation Compositor**, which allows
 the iOS to have a control of what is finally displayed on the screen.

**Layers**

The *Core Animation Compositor* offers *layers* that it combines to produce the final pixel colors in the *back frame buffer* that it swaps with the *front frame buffer*.
The layers provided by both the iOS operating system and the application are combined to render the resulting image. 

Consider the example where an application provides a layer that contains data to render a cyclinder to the *Core Animation Compositor*,
and the operating system provides a layer that contains data to draw the status bar, 
then the *Core Animation Compositor* of the Operating System combines both the layers to display a cylinder and a status bar on the screen.

Every iOS native user interface object has a corresponding *Core Animation layer*, so any application that uses several UI objects like buttons, text, images etc. use many layers.


