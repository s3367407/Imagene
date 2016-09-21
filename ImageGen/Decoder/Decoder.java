package ImageGen.Decoder;

import ImageGen.Decoder.Interfaces.IDecoder;
import ImageGen.Models.Pixel;
import ImageGen.Models.PixelMatrix;

public class Decoder implements IDecoder 
{

	@Override
	public PixelMatrix populate() {
		return new PixelMatrix(new Pixel(0, 0, 0), 3);
	}
	
	@Override
	public PixelMatrix populate(Pixel p) 
	{
		return new PixelMatrix(p, 3);
	}
}
