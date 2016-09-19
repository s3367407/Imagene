package ImageGen.Models;

import java.util.ArrayList;
import java.util.List;

public class PixelMatrix 
{
	private Pixel[][] matrix;
	
	public PixelMatrix(int xDim, int yDim)
	{
		matrix = new Pixel[yDim][xDim];
		set(new Pixel(0, 0, 0));
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
	
	public void set(int y, int x, Pixel p)
	{
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
	
	public int xSize()
	{
		return matrix[0].length; 
	}
	
	public int ySize()
	{
		return matrix.length;
	}
	
	public byte[] getByteArray()
	{
		byte[] bArray = new byte[getSize()*3];
		
		for(int i = 0; i < matrix[0].length - 1; i++)
		{
			for(int j = 0; j < matrix.length - 1; j++)
			{
				bArray[(3 * (i + j))] = (byte) matrix[i][j].r();
				bArray[(3 * (i + j)) + 1] = (byte) matrix[i][j].g();
				bArray[(3 * (i + j)) + 2] = (byte) matrix[i][j].b();
			}
		}
		
		return bArray;
	}
	
	public int[] getGreyScaleIntArray()
	{
		int rgb = 0, i = 0,	width = matrix[0].length, height = matrix.length;
		int[] iArray = new int[width*height];
		
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				rgb = (int)matrix[Math.abs(y-2)][Math.abs(x-2)].b();
				rgb = (rgb << 16) + (int)matrix[Math.abs(y-2)][Math.abs(x-2)].r();
				rgb = (rgb << 8) + (int)matrix[Math.abs(y-2)][Math.abs(x-2)].g();
				
				iArray[i++] = rgb;
			}
		}
		
		return iArray;
	}
	
	public int getSize()
	{
		return matrix[0].length * matrix.length;
	}
}
