import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Maze extends JPanel implements ActionListener {
	
	public int cols, rows;
	public int w = 40;
	
	public ArrayList<Cell> grid = new ArrayList<Cell>();
	public ArrayList<Cell> stack = new ArrayList<Cell>();
	
	public Cell cell;
	public Cell current;
	
	public Timer timer;
	public int delay = 60;
	
	
	public Maze()
	{
		
		this.cols = (int)700 / this.w;
		this.rows = (int)600 / this.w;
		
		for(int j = 0; j < this.rows; j++)
		{
			for(int i = 0; i < this.cols; i++)
			{
				cell = new Cell(i, j);
				grid.add(cell);
			}
		}
		
		current = grid.get(0);
		
		timer = new Timer(delay,this);
		timer.start();
					
	}
	
	public void removeWalls(Cell a, Cell b)
	{
		 int x = a.i - b.i;
		 
		 if (x == 1) 
		 {
		    a.walls[3] = false;
		    b.walls[1] = false;
		 } 
		 else if (x == -1) 
		 {
		    a.walls[1] = false;
		    b.walls[3] = false;
		 }
		 
		 int y = a.j - b.j;
		 
		 if (y == 1) 
		 {
		    a.walls[0] = false;
		    b.walls[2] = false;
		 } 
		 else if (y == -1) 
		 {
		    a.walls[2] = false;
		    b.walls[0] = false;
		 } 
	}
	
	
	public void paint(Graphics g)
	{
		g.setColor(Color.lightGray);
		g.fillRect(1, 1, 700, 600);
				
		for(int i = 0; i < grid.size(); i++)
		{
			grid.get(i).draw((Graphics2D)g);
		}
		
		current.visited = true;
		current.highlight((Graphics2D)g);

		g.dispose();
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		timer.start();
		
		// Etape 1
		Cell next = current.checkNeighbors(grid);
		
		if(next != null)
		{
			next.visited = true;
			
			// Etape 2
			stack.add(current);
			
			// Etape 3
			removeWalls(current, next);
			
			// Etape 4
			current = next;
		}
		else if(stack.size() > 0)
		{
			current = stack.remove(stack.size() - 1);
		}
		
		repaint();
	}
	
	
	

}


