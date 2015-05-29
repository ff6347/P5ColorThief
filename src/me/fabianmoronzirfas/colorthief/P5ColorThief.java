/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package me.fabianmoronzirfas.colorthief;


import processing.core.*;
import de.androidpit.colorthief.*;

import java.awt.image.BufferedImage;
/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own library or tool naming convention.
 * 
 * (the tag example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 * @example Hello 
 */

public class P5ColorThief {
	
	// myParent is a reference to the parent sketch
	PApplet myParent;

	private boolean debug = false;
	
	//	BufferedImage bimg = (BufferedImage) img.getImage();

	
	public final static String VERSION = "##library.prettyVersion##";
	

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example Hello
	 * @param theParent
	 */
	public P5ColorThief(PApplet theParent) {
		myParent = theParent;
		new ColorThief();

		welcome();
	}
	
	private void msg(String str){
		
		if (debug) System.out.println(str);

	}
	/**
	 * 
	 * @param img PImage the image to analyze
	 * @param num The number of colors to create 
	 * @return Array of colors
	 */
	 @SuppressWarnings({ "deprecation"})	
	public int [] getPalette(PImage img, int num){
//		BufferedImage bimg = (BufferedImage) img.getImage();
		int[][] pal = ColorThief.getPalette(transform(img), num);
		msg(Integer.toString(pal.length));
		int [] palette = new int[pal.length];
		for(int i = 0; i < pal.length; i++){
			palette[i] = myParent.color(pal[i][0], pal[i][1], pal[i][2]);
		}
		return palette;
	}

		public int [] getPalette(PImage img, int num, int quality, boolean ignoreWhite){
//			BufferedImage bimg = (BufferedImage) img.getImage();
			int[][] pal = ColorThief.getPalette(transform(img), num, quality, ignoreWhite);
			int [] palette = new int[pal.length];
			for(int i = 0; i < pal.length; i++){
				palette[i] = myParent.color(pal[i][0], pal[i][1], pal[i][2]);
			}
			return palette;
		}
		
	public int getColor(PImage img){
		int [] col = ColorThief.getColor(transform(img));
		
		return myParent.color(col[0], col[1], col[2]);
	}

	public int getColor(PImage img, int quality, boolean ignoreWhite){
		int [] col = ColorThief.getColor(transform(img),quality,ignoreWhite);
		
		return myParent.color(col[0], col[1], col[2]);
	}
	
	private  BufferedImage transform(PImage img){
		BufferedImage bimg = (BufferedImage) img.getImage();
		return bimg;
	}
	private void welcome() {
		System.out.println("##library.name## ##library.prettyVersion## by ##author##");
		System.out.println("based on: ");
		System.out.println("https://github.com/SvenWoltmann/color-thief-java by SvenWoltmann");
		System.out.println("Licensed under the Creative Commons Attribution 2.5 License");
	}
	
	
//	public String sayHello() {
//		return "hello library.";
//	}
	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

	/**
	 * 
	 * @param theA
	 *          the width of test
	 * @param theB
	 *          the height of test
	 */
//	public void setVariable(int theA, int theB) {
//		myVariable = theA + theB;
//	}

	/**
	 * 
	 * @return int
	 */
//	public int getVariable() {
//		return myVariable;
//	}
}

