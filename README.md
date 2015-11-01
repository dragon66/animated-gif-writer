#AnimatedGIFWriter
Standalone animated GIF writer.

How to use:

```java
// True for dither. Will use more memory and CPU
AnimatedGIFWriter writer = new AnimatedGIFWriter(true);
OutputStream os = new FileOutputStream("animated.gif");
// Grab the BufferedImage whatever way you can
BufferedImage frame;
// Use -1 for both logical screen width and height to use the first frame dimension
writer.prepareForWrite(os, -1, -1)
writer.writeFrame(os, frame);
// Keep adding frame here
writer.finishWrite(os);
// And you are done!!!
```

If used as a normal GIF writer:

```java
AnimatedGIFWriter writer = new AnimatedGIFWriter(true); // True for dither. Will need more memory and CPU
OutputStream os = new FileOutputStream("output.gif");
BufferedImage frame; // Grab the BufferedImage whatever way you can
writer.write(frame, os);
// And you are done!!!
```
