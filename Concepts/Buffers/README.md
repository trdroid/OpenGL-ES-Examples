# Buffers

The GPU controls and manages by taking the ownership of a contiguous range of RAM which is referred to as *buffers*. 

### CPU, GPU & RAM



### Ownership of Buffers

The programs which run on the CPU copy data from the CPU-managed memory to OpenGL ES *buffers*.

Once the GPU takes the ownership of the *buffers* it has exclusive control of them, which makes the buffer reads and writes very efficient.


The programs which run on the CPU ideally do not interact with the *buffers* 

The GPU processes the data in the buffers

* asynchronously &
* concurrently

### Supplying data to a buffer

The programs that run on the CPU provide data to the buffers for the GPU to process and render images. The data includes information about

* geometry
* colors
* lighting effects etc.

The programs provide data to the buffers by using the OpenGL ES API. A program typically follows the steps shown below when using the OpenGL ES API:

* **Generate a unique identifier**: The function *glGenBuffers()* of the OpenGL ES API is used to generate a unique identifier for a buffer.
* **Bind the buffer**: The function *glBindBuffer()* of the OpenGL ES API is used to bind the buffer for subsequent operations
* **Buffer data**: The functions *glBufferData()* or *glBufferSubData()* of the OpenGL ES API allocate and initialize sufficient contiguous memory for the currently bound buffer. This is most often done by copying data from the CPU controlled memory to the bound buffer.
* **Enable or disable data usage**: The functions *glEnableVertexAttribArray()* or *glDisableVertexAttribArray()* of the OpenGL ES API are used to specify if the data in the buffers should be used during subsequent rendering or not.
* **Configure data types and offsets**: The function *glVertexAttribPointer()* of the OpenGL ES API is used to specify the types of data in the buffer and any offsets required to access the data.
* **Render data**: The functions *glDrawArrays()* or *glDrawElements()* of the OpenGL ES API are used to render all or part of a scene using data in the currently bound and enabled buffers.
* **Delete buffers**: The function *glDeleteBuffers()* of the OpenGL ES API is used to delete the buffers and to free the resources. 


