package ImageGen;
import ImageGen.API.ProgramInterface;
import ImageGen.API.Interfaces.IProgramInterface;
import ImageGen.Manipulator.Interfaces.IManipulator;

public class TestDriver 
{
	static IProgramInterface api;
	static IManipulator function; 
	
	public static void main(String[] args) 
	{
		api = new ProgramInterface();
		api.CreateImage(300, 300, function = (x, y) -> (double)(x + y));
		api.CreateImage(300, 300, function = (x, y) -> (double)(x = y));
		api.CreateImage(300, 300, function = (x, y) -> (double)((int)Math.cos(x) + y^2));
	}
}