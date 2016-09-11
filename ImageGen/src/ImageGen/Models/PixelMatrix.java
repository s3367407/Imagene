package ImageGen.Models;

public class PixelMatrix 
{
	private Pixel[][] matrix;
	
	public PixelMatrix(int xDim, int yDim)
	{
		matrix = new Pixel[xDim][yDim];
	}
	
	public PixelMatrix(Pixel p, int size) 
	{ 
		matrix = new Pixel[size][size]; 
		set(p); 
	}
	
	public PixelMatrix() { }
	public PixelMatrix(PixelMatrix m) {	set(m); }
	public PixelMatrix(Pixel[][] m)	{ set(m); }

	public Pixel[][] get()
	{
		return this.matrix;
	}
	
	public Pixel get(int y, int x)
	{
		return this.matrix[y][x];
	}
	
	public void set(int x, int y, Pixel p)
	{
		if(x <= matrix[0].length && y <= matrix.length)
			matrix[y][x] = p;
	}
	
	public void set(Pixel[][] m)
	{
		matrix = m;
	}
	
	public void set(PixelMatrix m)
	{
		matrix = m.get();
	}
	
	public void set(Pixel p)
	{
		for(int i = 0; i < matrix[0].length; i++)
		{
			for(int j = 0; j < matrix.length; j++)
			{
				matrix[j][i] = p;
			}
		}
	}
	
	public void print()
	{
		for(int i = 0; i < matrix[0].length; i++)
		{
			for(int j = 0; j < matrix.length; j++)
			{
				System.out.print(matrix[j][i].ToString());
			}
			System.out.println();
		}
	}
}
