package ImageGen.Manipulator.Algorithms;

import ImageGen.Manipulator.Interfaces.IManipulator;
import ImageGen.Models.Pixel;

public class MinusPixel implements IManipulator {

	@Override
	public Pixel manipulate(Pixel a, Pixel b) {
		return new Pixel(a.r()-b.r(), a.g()-b.g(), a.b()-b.b());
	}

}
