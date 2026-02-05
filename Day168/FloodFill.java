package Day168;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FloodFill {
    static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    static int[][] flood_fill(int sr,int sc,int color,int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] ans = mat;
        int oldColor = mat[sr][sc];
        ans[sr][sc] = color;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        int[] drow = {0,0,-1,1};
        int[] dcol = {1,-1,0,0};
        while(!q.isEmpty()){
            Pair top = q.poll();
            int row = top.row;
            int col = top.col;
            for(int i = 0;i<4;i++){
                int nrow = row+drow[i];
                    int ncol = col+dcol[i];
                    if(nrow >=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol] == oldColor && vis[nrow][ncol] == 0){
                        ans[nrow][ncol] = color;
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows");
        int n = sc.nextInt();
        System.out.println("Enter no. of columns");
        int m = sc.nextInt();
        System.out.println("Enter elements ");
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] ans = flood_fill(2, 0, 3, arr);
        display(ans);
        sc.close();
    }
    
}
