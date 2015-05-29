/**
 * Simple sketch that shows how to grap colors from a short video
 * @author: Fabian Morón Zirfas
 *
 */
// import the needed libraries
import processing.video.*;
import me.fabianmoronzirfas.colorthief.*;

P5ColorThief thief; // our thief object
Movie video;  // will hold the video
int x = 100; // this is for displaying the palette
int y = 0; // same thing here

void setup() {
  video = new Movie(this, "example.mov");// load the video
  thief = new P5ColorThief(this);// enter "THE THIEF"
  size(200, 100); // 2 times the size of the video
  video.loop(); // loop it
  video.play(); // play it
  // reduce the speed so it is better to see whats going on
  frameRate(5);
}
void draw() {
  image(video, 0, 0); // display the video
  PImage frame = video.get(); // grap the latest frame
  // extract the palette
  color [] palette = thief.getPalette(frame, 5);
  // loop the palette
  // and create some rectangles from its colors
  for (int i = 0; i < palette.length; i++) {
    fill(palette[i]);
    rect(x, y, 5, 5);
    x+=5;
    // constrain it to the screen
    if (x == width) {
      y+=5;
      x=100;
    } // end if width
    if (y== height) {
      y = 0;
    } // end if height
  }// end loop
} // end draw
// needed to grap the video
void movieEvent(Movie m) {
  m.read();
}

