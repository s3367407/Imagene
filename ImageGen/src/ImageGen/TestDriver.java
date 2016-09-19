package ImageGen;

import java.awt.Point;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
		PixelMatrix p = api.CreateImage(1000, 1000, function = 
				(x, y) -> (double) ( x^2 + y^2 ) );
		
	    try {
			ImageIO.write(makeImage(p.xSize(), p.ySize(), p.getGreyScaleIntArray()), 
					"png", new File("xsquared+ysquaredBIG.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static RenderedImage makeImage(int width, int height, int[] data)
	{
	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    image.setRGB(0, 0, width, height, data, 0, width);
	    
	    return (RenderedImage) image;
	}
}