// path class to store the next move in Maze
//class used in Maze.java
public class Path
{
	public int row;
	public int col;

	public Path(int rw, int co)
	{
		this.row = rw;
		this.col = co;
	}

	public String toString()
	{
		String str = "<" + this.row + "," + this.col + ">";
		return str;
	}
}
