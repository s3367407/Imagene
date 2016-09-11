package ImageGen;
import ImageGen.API.ProgramInterface;
import ImageGen.API.Interfaces.IProgramInterface;
import ImageGen.Models.Pixel;

// Custom Algorithms
import ImageGen.Manipulator.Algorithms.PlusPixel;

public class TestDriver 
{
	static IProgramInterface api;
	public static void main(String[] args) 
	{
		api = new ProgramInterface();
		
		/** Each method allows you to plug in your own algorithm, so instead of
		   rewriting the functions, you only have to write a new algorithm if you
		   come up with a better one that implements IManipulator. */
		
		System.out.println(String.format("%25s", "== ADDING =="));
		api.add(new Pixel(10, 255, 15), new Pixel(20, 255, 1000006), new PlusPixel());
		
		/** But the API will select a default algorithm if one is not provided */
		
		System.out.println(String.format("%25s", "== SUBTRACTING =="));
		api.subtract(new Pixel(25, 50, 0), new Pixel(200, 40, 254));
		
		/*
		System.out.println("Cos:");
		api.cos(new Pixel(6, 6, 6), new Pixel(125, 125, 125), new CosPixel());
		*/
	}
}
