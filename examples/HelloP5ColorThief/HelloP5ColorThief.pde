/**
 * P5ColorThief
 * Wrapper written by Fabian Morón Zirfas
 *
 * for 
 * https://github.com/SvenWoltmann/color-thief-java
 *
 * by SvenWoltmann
 * Licensed under the
 * Creative Commons Attribution 2.5 License
 *
 * Simple Sketch that generates a color palette from 
 * an imported image
 * 
 */

import me.fabianmoronzirfas.colorthief.*;

P5ColorThief ct; // setup the color thief
PImage img; // the image to analyse

void setup() {
  size(100, 100);
  img = loadImage("ldr.jpg");// load the image
  ct = new P5ColorThief(this); // init the thief
  /**
   * @param img PImage to analyse
   * @param num int Number of colors in palette
   * @return Array of colors
   */
  color [] palette = ct.getPalette(img, 3); // analyse
  /**
   * could also be like this
   * @param img PImage to analyse
   * @param num int Number of colors in palette
   * @param quality int Quality of analysis
   * @param ignoreWhite boolean tells the thief to ignore white
   * @return Array of colors
   */
  // color [] palette = ct.getPalette(img, 3,5, true); // analyse
  // this is for displaying the result
  int step = width/palette.length; 
  int x = 0;
  int y = 0;
  int w = step;
  int h = (height/3) * 2;
  noStroke(); // style
  // loop the palette
  for (int i = 0; i < palette.length; i++) {
    fill(palette[i]); // get the color
    rect(x, y, w, h); // display it
    x+=step; // increase the x value
  }
  /**
   * @param img PImage to analyse
   * @return color
   */
  color dominantColor = ct.getColor(img);
  /**
   * Could also be like this
   * @param img PImage to analyse
   * @param quality int Quality of analysis
   * @param ignoreWhite boolean tells the thief to ignore white
   * @return color
   */
  // color dominantColor = ct.getColor(img, 5, true);

  fill(dominantColor);
  rect(0, (height/3)*2, width, h);
}

void draw() {
}

