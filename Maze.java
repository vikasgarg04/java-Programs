import java.util.*;
import java.lang.*;

public class Maze
{
	public int dir;
	public char[][] arr;
	public int rows;
	public int cols;
	LinkedList<Path> sol;
	Path path;

	public Maze(char a[][], int r, int c)
	{
		this.rows = r; // total rows in a Maze
		this.cols = c; // total columns in a Maze
		this.arr = new char[r][c]; // Maze
		sol = new LinkedList<Path>(); // List to store the path of Maze
		path = null;

		for(int i = 0; i < this.rows; i++)
		{
			for(int j = 0; j < this.cols; j++)
			{
				arr[i][j] = a[i][j];
			}
		}
	}

	// check Maze weather there is a solution of Maze or not
	public boolean valid(int r, int c)
	{
		int row = r; // starting row of Maze
		int col = c; // starting column of Maze
		this.arr[row][col] = 'S';
		
		// direction of Maze where a person will move

		// dir == 1 --> South Direction
		// dir == 2 --> East Direction
		// dir == 1 --> North Direction
		// dir == 1 --> West Direction
		this.dir = 0;  

		path = new Path(row, col);
		sol.add(path);
		
		// flag is used to maintain the right moves
		int flag = 1;
		Path prev = null;
		
		// checking the Maze for Solution
		do
		{ 
			for(int i = 0; i < 3; i++)
			{
				this.dir = this.dir % 4;
				this.dir++;
				
				if(this.dir == 1 && this.arr[row + 1][col] != '#')
				{
					row++;
					this.dir = 3;
					break;
				}
				if(this.dir == 2 && this.arr[row][col + 1] != '#')
				{
					col++;
					this.dir = this.dir - 2;			
					break;
				}
				if(this.dir == 3 && this.arr[row - 1][col] != '#')
				{
					row--;
					this.dir = this.dir - 2;
					break;
				}
				if(this.dir == 4 && this.arr[row][col - 1] != '#')
				{
					col--;
					this.dir = this.dir - 2;
					break;
				}
			}

			// maintaing the path
			if(row == sol.getLast().row && col == sol.getLast().col)
			{
				prev = sol.removeLast();
				flag = 0;
			}
			else
			{
				if(flag == 0)
					sol.add(prev);

				path = new Path(row, col);
				sol.add(path);
				flag = 1;
			}
		}while(row > 0 && row < this.rows - 1 && col > 0 && col < this.cols - 1);

		// return false if there is no solution, otherwise display the solution and print the path
		if(r == row && c == col)
			return false;
		else
		{
			System.out.print("START--> " + sol.get(0));
			ListIterator<Path> itr = sol.listIterator(1);
			while(itr.hasNext())
			{
				Path tmp = itr.next();
				System.out.print(" " + tmp);
				this.arr[tmp.row][tmp.col] = ' ';
			}
			this.arr[row][col] = 'E';
			System.out.println(" <--END");

			displayMaze();
			
			return true;
		}
	}

	// print the Maze with Solution
	public void displayMaze()
	{
		for(int i = 0; i < this.rows; i++)
		{
			for(int j = 0; j < this.cols; j++)
			{
				System.out.print(this.arr[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}