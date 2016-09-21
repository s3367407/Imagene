package ImageGen.API.Interfaces;

import ImageGen.Manipulator.Interfaces.IManipulator;
import ImageGen.Models.PixelMatrix;

public interface IProgramInterface 
{
	public PixelMatrix CreateImage(int x, int y, IManipulator m);
}
