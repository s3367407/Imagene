/**
 * When I'm up to the point where I am confident in plugging in actual images, 
 * all of these can be replaced by Pixel manipulate(Pixel a, Pixel b, IManipulator m)
 */

package ImageGen.API;
import ImageGen.Manipulator.Interfaces.IManipulator;
import ImageGen.Models.Pixel;
import ImageGen.Models.PixelMatrix;
// Default Algorithms
import ImageGen.Manipulator.Algorithms.PlusPixel;
import ImageGen.Manipulator.Algorithms.MinusPixel;
import ImageGen.API.Interfaces.IProgramInterface;
import ImageGen.Codec.Codec;
import ImageGen.Codec.Interfaces.ICodec;
import ImageGen.Manipulator.Algorithms.CosPixel;

public class ProgramInterface implements IProgramInterface
{
	private ICodec codec;
	
	public ProgramInterface()
	{
		codec = new Codec();
	}

	@Override
	public void add(Pixel a, Pixel b, IManipulator m) {
		PixelMatrix image1, image2, image3;
		
		image1 = codec.decode(a);
		image2 = codec.decode(b);
		
		System.out.println("Image1 :");
		image1.print();
		System.out.println("Image2 :");
		image2.print();
		
		image3 = manipulate(image1, image2, m);
		
		System.out.println("Image1 + Image2 :");
		image3.print();
		System.out.println();
	}

	@Override
	public void subtract(Pixel a, Pixel b, IManipulator m) {
		PixelMatrix image1, image2, image3;
		
		image1 = codec.decode(a);
		image2 = codec.decode(b);
		
		System.out.println("Image1 :");
		image1.print();
		System.out.println("Image2 :");
		image2.print();
		
		image3 = manipulate(image1, image2, m);
		
		System.out.println("Image1 - Image2 :");
		image3.print();
		System.out.println();
	}

	@Override
	public void cos(Pixel a, Pixel b, IManipulator m) {
		PixelMatrix image1, image2, image3;
		
		image1 = codec.decode(a);
		image2 = codec.decode(b);
		
		System.out.println("Image1 :");
		image1.print();
		System.out.println("Image2 :");
		image2.print();
		
		image3 = manipulate(image1, image2, m);
		
		System.out.println("Image1 acos Image2 :");
		image3.print();
		System.out.println();
	}
	
	private PixelMatrix manipulate(PixelMatrix a, PixelMatrix b, IManipulator m)
	{
		for(int i = 0; i < a.get()[0].length; i++)
			for(int j = 0; j < a.get().length; j++)
				a.set(i, j, m.manipulate(a.get(j, i), b.get(j, i)));
		
		return new PixelMatrix(a);
	}
	
	private Pixel manipulate(Pixel a, Pixel b, IManipulator m)
	{
		return m.manipulate(a, b);
	}

	@Override
	public void add(Pixel a, Pixel b) { add(a, b, new PlusPixel());	}

	@Override
	public void subtract(Pixel a, Pixel b) { subtract(a, b, new MinusPixel()); }

	@Override
	public void cos(Pixel a, Pixel b) { cos(a, b, new CosPixel()); }
}
