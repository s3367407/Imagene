package ImageGen.Models;

public class Pixel
{
	private short r, g, b;
	
	public Pixel(int r, int g, int b)
	{
		this((short)r, (short)g, (short)b);
	}
	
	public Pixel(double r, double g, double b)
	{
		this((short)Math.round(r), (short)Math.round(g), (short)Math.round(b));
	}
	
	public Pixel(short r, short g, short b)
	{
		this.r = set(r);
		this.g = set(g);
		this.b = set(b);	
	}

	public short r() { return this.r; }
	public short g() { return this.g; }
	public short b() { return this.b; }
	
	public String ToString()
	{
		return String.format("[%3d,", this.r) + String.format("%3d,", this.g) + String.format("%3d]", this.b);
	}
	
	public short set(short a)
	{
		short result;
		if(a == 0)
			result = (short) 0;
		if(a % 255 == 0)
			result = (short) 255;
		else
			result = (short) (a % 255);
		
		if(result < 0) result += 255;
		
		return result;
	}
}
