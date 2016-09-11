package ImageGen.API.Interfaces;

import ImageGen.Manipulator.Interfaces.IManipulator;
import ImageGen.Models.Pixel;

public interface IProgramInterface 
{
	public void add(Pixel a, Pixel b);
	public void add(Pixel a, Pixel b, IManipulator m);
	public void subtract(Pixel a, Pixel b);
	public void subtract(Pixel a, Pixel b, IManipulator m);
	public void cos(Pixel a, Pixel b);
	public void cos(Pixel a, Pixel b, IManipulator m);
}
