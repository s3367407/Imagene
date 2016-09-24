package imagene.backend.ImageGen.API.Interfaces;

import imagene.backend.ImageGen.Manipulator.Interfaces.IManipulator;
import imagene.backend.ImageGen.Models.PixelMatrix;

public interface IProgramInterface 
{
	public PixelMatrix CreateImage(int x, int y, IManipulator m);
}
