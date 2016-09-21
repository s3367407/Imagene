package ImageGen.API;
import ImageGen.Manipulator.Interfaces.IManipulator;
import ImageGen.Models.Pixel;
import ImageGen.Models.PixelMatrix;
import ImageGen.Timer;
import ImageGen.API.Interfaces.IProgramInterface;

public class ProgramInterface implements IProgramInterface
{
	
	public ProgramInterface()
	{
		
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
				matrix.set(dimY, dimX, p);
			}
		}
		matrix = ScaleImage(matrix, min, max);
		long totalTime = Timer.stop(startTime);
		
		System.out.println(" CREATED in "+totalTime+" milliseconds.");
		System.out.println("MIN is "+min+", MAX is "+max);
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
				m.set(dimY, dimX, new Pixel(ScalePixel(m.get(dimY, dimX).magnitude(), min, max)));
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
