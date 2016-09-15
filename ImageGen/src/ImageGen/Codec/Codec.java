package ImageGen.Codec;

import java.awt.image.BufferedImage;

import ImageGen.Codec.Interfaces.ICodec;
import ImageGen.Decoder.Decoder;
import ImageGen.Decoder.Interfaces.IDecoder;
import ImageGen.Models.Pixel;
import ImageGen.Models.PixelMatrix;

public class Codec implements ICodec 
{
	private IDecoder decoder;
	
	public Codec()
	{
		decoder = new Decoder();
	}
	
	@Override
	public PixelMatrix decode(Pixel p)
	{
		return decoder.populate(p);
	}

	@Override
	public PixelMatrix decode(BufferedImage b) 
	{
		return null;
	}
}
