package ImageGen.Codec.Interfaces;

import java.awt.image.BufferedImage;

import ImageGen.Models.Pixel;
import ImageGen.Models.PixelMatrix;

public interface ICodec 
{	
	public PixelMatrix decode(Pixel p);
	public PixelMatrix decode(BufferedImage b);
	public BufferedImage encode(PixelMatrix m);
}
