import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class Cell {
	
	public int i, j;
	public boolean[] walls = {true, true, true, true};
	public boolean visited = false;
	
	public int w = 40;
	
	public Cell(int i, int j)
	{
		this.i = i;
		this.j = j;
			
	}
	
	public void draw(Graphics2D g) 
	{
		int x = this.i * this.w;
		int y = this.j * this.w;
		
		if(this.walls[0])
		{
			g.setColor(Color.black);
			g.drawLine(x, y, x + this.w, y);
		}
		if(this.walls[1])
		{
			g.setColor(Color.black);
			g.drawLine(x + this.w, y, x + this.w, y + this.w);
		}
		if(this.walls[2])
		{
			g.setColor(Color.black);
			g.drawLine(x + this.w, y + this.w, x, y + this.w);
		}
		if(this.walls[3])
		{
			g.setColor(Color.black);
			g.drawLine(x, y + this.w, x, y);
		}
		
		
//		if(this.visited)
//		{			
//			g.setColor(Color.magenta);
//			g.fillRect(x-2, y-2, 40,40);			
//		}
		
	}
	
	public void highlight(Graphics2D g)
	{
		int x = this.i * this.w;
		int y = this.j * this.w;
		
		g.setColor(Color.green);
		g.fillRect(x, y, this.w, this.w);
				
	}
	
	public int index(int i, int j)
	{
		if (i < 0 || j < 0 || i > 16 || j > 13) 
		{
		    return 0;
		}
		
		return i + j * 17;
	}
	
	
	public Cell checkNeighbors(ArrayList<Cell> grid)
	{
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		
		Cell top = grid.get(index(i, j - 1));
		Cell right  = grid.get(index(i + 1, j));
	    Cell bottom = grid.get(index(i, j + 1));
	    Cell left   = grid.get(index(i - 1, j));
		
		if(top != null && !top.visited)
		{
			neighbors.add(top);
		}
		
		if(right != null && !right.visited)
		{
			neighbors.add(right);
		}
		
		if(bottom != null && !bottom.visited)
		{
			neighbors.add(bottom);
		}
		
		if(left != null && !left.visited)
		{
			neighbors.add(left);
		}
		
		
		if(neighbors.size() > 0)
		{
			int r = (int)(Math.random() * neighbors.size());
			return neighbors.get(r);
		}
		else
		{
			return null;
		}
		
	}
		
}
