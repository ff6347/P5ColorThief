P5ColorThief
============

A Processing wrapper for [https://github.com/SvenWoltmann/color-thief-java](https://github.com/SvenWoltmann/color-thief-java)

Download the library [here](https://github.com/fabiantheblind/P5ColorThief/releases/download/1.0.0/P5ColorThief.zip).

##Examples  

### HelloP5ColorThief.pde  
![](web/assets/HelloP5ColorThief.png)  

Shows the basic usage of the library.  

### P5ColorThiefVideo.pde  
![](web/assets/P5ColorThiefVideo.png)  

Shows how to extract color palettes from videos frame by frame.  

## Usage  

First import the library  

    import me.fabianmoronzirfas.colorthief.*;

Then make a new color thief object

    P5ColorThief ct;

Initialize the object in void setup

    ct = new P5ColorThief(this);

Load your image

      PImage myImage = loadImage("test.jpg");


Get the dominat colors from your image

    color [] palette = ct.getPalette(myImage, 3);

Now you have an array of colors that you can use.

Also available methods are:  

    color [] palette = ct.getPalette(PImage img, int numberOfColors, int quality, boolean ignoreWhite);
    color dominantColor = ct.getColor(PImage img);
    color dominantColor = ct.getColor(PImage img, int quality, boolean ignoreWhite);
    


###Thanks

- Lokesh Dhakar - for the original Color Thief JavaScript version, available at [Color Thief](http://lokeshdhakar.com/projects/color-thief/)  
- Sven Woltmann - for writing the Java port available at [SvenWoltmann/color-thief-java · GitHub](https://github.com/SvenWoltmann/color-thief-java)

###License

Licensed under the Creative Commons Attribution 2.5 License  

Free for use in both personal and commercial projects.  
Attribution requires leaving author name, author homepage link, and the license info intact.  