// path class to store the next move in Maze
public class Path
{
	public int row;
	public int col;

	public Path(int r, int c)
	{
		this.row = r;
		this.col = c;
	}

	public String toString()
	{
		String str = "<" + this.row + "," + this.col + ">";
		return str;
	}
}