package Day165;

import java.util.*;
public class DistanceOfNearestCellHaving1 {
    static class Pair{
        int row;
        int col;
        int d;
        Pair(int row,int col,int d){
            this.row = row;
            this.col = col;
            this.d = d;
        }
    }
    static void display(int[][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int[][] nearest(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 1){
                    q.add(new Pair(i, j,0));
                    vis[i][j] = 1;
                }
                else vis[i][j] = 0;
            }
        }
        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,1,-1}; 
        while(!q.isEmpty()){
            Pair top = q.poll();
            int row = top.row;
            int col = top.col;
            int di = top.d;
            dist[row][col] = di;
            for(int i = 0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && nrow<n && ncol >= 0 && ncol<m && mat[nrow][ncol] == 0 && vis[nrow][ncol] != 1){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, di+1));
                }
            }
        }
        return dist;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int r = sc.nextInt();
        System.out.println("Enter columns");
        int c = sc.nextInt();
        int[][] mat = new int[r][c];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int[][] ans = nearest(mat);
        display(ans);
        sc.close();
    }
    
}

