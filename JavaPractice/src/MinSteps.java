import java.util.*;

public class MinSteps {
	public class Point {
        public int x, y;
        public Point(int row, int column) {
        	super();
        	this.x = row;
            this.y = column;
        }
    }
	
	public class QueueNode {
		public Point pt;
		public int dist;
		public QueueNode(Point pt, int dist) {
			super();
			this.pt = pt;
			this.dist = dist;
		}
	}
	
	public static boolean isValid(int ROW, int COL, int row, int col)
	{
	    return (row >= 0) && (row < ROW) &&
	           (col >= 0) && (col < COL);
	}
	
    public int BFS(int mat[][], Point src, Point dest)
    {
    	int rowNum[] = {-1, 0, 0, 1};
    	int colNum[] = {0, -1, 1, 0};
    	int ROW = mat.length;
    	int COL = mat[0].length;
    	boolean visited[][] = new boolean[ROW][COL];

        visited[src.x][src.y] = true;
        
        Queue<QueueNode> q = new LinkedList<QueueNode>();
        QueueNode source = new QueueNode(src, 0);
        q.add(source);
     
        while (!q.isEmpty())
        {
            QueueNode curr = q.poll();
            Point pt = curr.pt;
            
            if (pt.x == dest.x && pt.y == dest.y)
                return curr.dist;
            
            for (int i = 0; i < 4; i++)
            {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];
            	
                if (isValid(ROW, COL, row, col) && !visited[row][col] && mat[row][col] == 0) {
                
                    visited[row][col] = true;
                    Point newPoint = new Point(row,col);
                    QueueNode Adjcell = new QueueNode(newPoint, curr.dist + 1 );
                    q.add(Adjcell);
                }
            }
        }
      	return -1;
    }	
    
    public static void main(String args[]) {
    	MinSteps ms = new MinSteps();
    	int mat[][] =
    		{
    				{ 0, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
    				{ 1, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
    				{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
    				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
    				{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
    				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
    				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
    				{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
    		};
     
        Point source = ms.new Point(0, 0);
        Point dest = ms.new Point(4, 3);
     
        int dist = ms.BFS(mat, source, dest);
     
        if (dist != -1)
            System.out.println("Shortest Path is: " + dist);
        else
        	System.out.println("Shortest Path doesn't exist");
    }
}
