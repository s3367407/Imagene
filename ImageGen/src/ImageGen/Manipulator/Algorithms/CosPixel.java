package ImageGen.Manipulator.Algorithms;

import ImageGen.Manipulator.Interfaces.IManipulator;
import ImageGen.Models.Pixel;

public class CosPixel implements IManipulator {

	@Override
	public Pixel manipulate(Pixel a, Pixel b) {
		return new Pixel(Math.acos(a.r()/b.r()), Math.acos(a.g()/b.g()), Math.acos(a.b()/b.b()));
	}
}
