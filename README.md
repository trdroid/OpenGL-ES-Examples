# OpenGL ES

### 3D Rendering

*Rendering* is the process of generating a 2D image from 3D data. An image is composed of an array of rectangular dots called *pixels*. 

The data containing information about 

* colors
* lights
* geometry

is processed by the Graphics Processing Unit (GPU) to produce an image on the screen. 

### Frame Buffer

The GPU stores the output of rendering i.e. the rendered 2D image pixel data after processing the input 3D data in buffers called as *frame buffers*. 

*Initializing frame buffers*

Initializing frame buffers is not necessary as their content is replaced in the rendering process.

*More than one frame buffer*

More than one frame buffer can exist at any point in time. OpenGL ES can be configured to allow the GPU to render into any any number of frame buffers.

**Front Frame Buffer**

The *front frame buffer* is the ONLY frame buffer which determines the pixel colors on the display. The pixel color elements values stored in the *front frame buffer* control the pixel colors on the display. 

**Rendering directly into front frame buffer**

Rendering directly into the *front frame buffer* results in partially completed images being displayed while the rendering process progresses. 

**Back Frame Buffer**

The programs and the operating system most often render into frames called as *back frame buffers*. When the rendering is complete, the *front frame buffer* and the *back frame buffer* are swapped almost instantaneously. 
