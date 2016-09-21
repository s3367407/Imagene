/** Commenting for android sanity.
package ImageGen;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ImageGen.API.ProgramInterface;
import ImageGen.API.Interfaces.IProgramInterface;
import ImageGen.Manipulator.Interfaces.IManipulator;
import ImageGen.Models.PixelMatrix;

public class TestDriver 
{
	static IProgramInterface api;
	static IManipulator function; 
	
	public static void main(String[] args) 
	{
		api = new ProgramInterface();
		PixelMatrix p = api.CreateImage(300, 300, function = 
				(x, y) -> (double) ( Math.pow(x, 2) + Math.pow(y, 2) ));
		
		//Doesn't work yet
		//draw(p, p.polarConversion(), "x2+y2polar0origin.png");
	}
	
	public static RenderedImage makeImage(int width, int height, int[] data)
	{
	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    System.out.println("WIDTH: " + width + ", HEIGHT: "+ height);
	    image.setRGB(0, 0, width, height, data, 0, width);
	    
	    return (RenderedImage) image;
	}
	
	public static void draw(PixelMatrix p, int[] style, String filename)
	{
		try {
			ImageIO.write(makeImage(p.xSize(), p.ySize(), style), 
					"png", new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}*/