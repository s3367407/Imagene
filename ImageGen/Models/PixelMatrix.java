package ImageGen.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ImageGen.Polar.Coordinate;

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
	
	public int[] getIntArray()
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
	
	public int[] polarConversion()
	{
		int rgb = 0, i = 0,	width = matrix[0].length, height = matrix.length;
		int[][] pArray = new int[height][width];
		
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				Coordinate c = getPolarCoordFromCartesian(y, x, height); 
				rgb = (int)matrix[Math.abs(y-2)][Math.abs(x-2)].b();
				rgb = (rgb << 16) + (int)matrix[Math.abs(y-2)][Math.abs(x-2)].r();
				rgb = (rgb << 8) + (int)matrix[Math.abs(y-2)][Math.abs(x-2)].g();
				
				try {
					pArray[c.y][c.x] = c.y+c.x;//rgb;
				} catch(Exception ex) {  }
			}
		}
		
		return dimensionalConversion(pArray);
	}
	
	//Change this
	private int[] dimensionalConversion (int[][] arr)
	{
		int[] array = new int[arr.length*arr[0].length];
		int i = 0;
	    for (int y= 0; y < arr.length; y++) {
	        for (int x = 0; x < arr[i].length; x++) {
	        	try {
	        		array[i] = arr[y][x];
	        	} catch (Exception ex) {
	        		System.err.println("["+y+","+x+"] = "+i);
	        	}
	            i++;
	        }
	    } 
	    return array;
	}
	
	private Coordinate getPolarCoordFromCartesian(int y, int x, int height)
	{
		double r, q;
		
		r = Math.sqrt(Math.pow(y, 2) + Math.pow(x, 2));
		try {
			q = Math.toDegrees(Math.atan2((double)y,(double)x));
		} catch(Exception e) {
			q = 0;
		}
		
		return new Coordinate((int)x, scale(y, height));
	}
	
	private int scale(double magnitude, double max) {
		  return (int)Math.round(max * magnitude/max);
	}
	
	public int getSize()
	{
		return matrix[0].length * matrix.length;
	}
}
