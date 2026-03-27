package Day203;

public class RatInAMaze4D1S {
    static int minDist_rec(int i,int j,int n,int[][] visited){
        if(i == n-1 && j == n-1) return 0;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        visited[i][j] = 1;
        int res = 1;
        if(j>0 && visited[i][j-1] != 1){
            res = minDist_rec(i, j-1, n,visited);
            if(res != Integer.MAX_VALUE) left = 1+res;
        }
        if(j<n-1 && visited[i][j+1] != 1) {
            res = minDist_rec(i, j+1,n,visited);
            if(res != Integer.MAX_VALUE) right = 1+res;
        }
        if(i>0 && visited[i-1][j] != 1) {
            res = minDist_rec(i-1, j, n,visited);
            if(res != Integer.MAX_VALUE) up = 1+res;
        }
        if(i<n-1 && visited[i+1][j] != 1) {
            res = minDist_rec(i+1, j, n,visited);
            if(res != Integer.MAX_VALUE) down = 1+res;
        }
        visited[i][j] = 0;
        return Math.min(Math.min(right, left), Math.min(up, down));
    }
    public static void main(String[] args) {
        int[][] vis = new int[4][4];
        System.out.println(minDist_rec(0, 0, 4,vis));
    }
    
}
