package ImageGen.Decoder.Interfaces;

import ImageGen.Models.Pixel;
import ImageGen.Models.PixelMatrix;

public interface IDecoder 
{
	public PixelMatrix populate();
	public PixelMatrix populate(Pixel p);
}
