/**
 * When I'm up to the point where I am confident in plugging in actual images, 
 * all of these can be replaced by Pixel manipulate(Pixel a, Pixel b, IManipulator m)
 */

package ImageGen.API;
import ImageGen.Manipulator.Interfaces.IManipulator;
import ImageGen.Models.Pixel;
import ImageGen.Models.PixelMatrix;
import ImageGen.Timer;
import ImageGen.API.Interfaces.IProgramInterface;
import ImageGen.Codec.Codec;
import ImageGen.Codec.Interfaces.ICodec;

public class ProgramInterface implements IProgramInterface
{
	private ICodec codec;
	
	public ProgramInterface()
	{
		codec = new Codec();
	}
	
	@Override
	public PixelMatrix CreateImage(int x, int y, IManipulator m)
	{
		long startTime = Timer.start();
		PixelMatrix matrix = new PixelMatrix(x, y);
		double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		for(int dimY = 0; dimY < y; dimY++)
		{
			for(int dimX = 0; dimX < x; dimX++)
			{
				Pixel p = new Pixel(m.manipulate(dimX, dimY));
				if(p.magnitude() > max) max = p.magnitude();
				if(p.magnitude() < min) min = p.magnitude();
				matrix.set(dimX, dimY, p);
			}
		}
		matrix = ScaleImage(matrix, min, max);
		long totalTime = Timer.stop(startTime);
		
		System.out.println(" CREATED in "+totalTime+" milliseconds.");
		return matrix;
	}
	
	private PixelMatrix ScaleImage(PixelMatrix m, double min, double max)
	{
		long startTime = Timer.start();
		int x = m.xSize(), y = m.ySize();
		
		for(int dimY = 0; dimY < y; dimY++)
		{
			for(int dimX = 0; dimX < x; dimX++)
			{
				m.set(dimX, dimY, new Pixel(ScalePixel(m.get(dimX, dimY).magnitude(), min, max)));
			}
		}
		
		long totalTime = Timer.stop(startTime);
		
		System.out.print("Image of size ["+x+"x"+y+"] SCALED in "+totalTime+" milliseconds,");
		return m;		
	}
	
	private short ScalePixel(double magnitude, double min, double max) {
		  return (short)Math.round(255 * (magnitude - min) / (max - min));
	}
}
