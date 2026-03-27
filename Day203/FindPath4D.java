package Day203;

public class FindPath4D {
    static void solveMaze(int[][] maze, int x,int y,String path,int[][] visited){
        int n =  maze.length;
        int m = maze[0].length;
        if(x == n-1 && y == m-1){
            System.out.println(path);
            return;
        }
        int[] row = {1,-1,0,0};
        int[] col = {0,0,1,-1};
        char[] moveChar = {'D','L','R','U'};
        for(int i = 0;i<4;i++){
            int nrow = row[i]+x;
            int ncol = col[i]+y;
            if(nrow >=0 && ncol >=0 && nrow <n && ncol <m && visited[nrow][ncol] != 0 && maze[nrow][ncol] == 1){
                solveMaze(maze, nrow, ncol, path+moveChar[i], visited);
                visited[nrow][ncol] = 1;
            }
        }
        visited[x][y] = 0;


    }
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] visited = new int[n][m];
        // int[][] maze = new int[n][m];
        int[][] maze = {{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
        solveMaze(maze, 0, 0, "", visited);
    }
    
}
