package Day166;

import java.util.*;
public class FloodFill {
    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
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
    static int[][] flood_filled(int[][] mat,int sr,int sc,int color){
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] ans = mat;
        Queue<Pair> q = new LinkedList<>();
        int initial = mat[sr][sc];
        ans[sr][sc] = color;
        vis[sr][sc] = 1;
        q.add(new Pair(sr, sc));
        int[] drow = {-1,1,0,0};
        int[] dcol = {0,0,-1,1};
        while(!q.isEmpty()){
            Pair top = q.poll();
            int row = top.row;
            int col = top.col;
            for(int i = 0;i<4;i++){
                for(int j = 0;j<4;j++){
                    int nrow = row + drow[i];
                    int ncol = col + dcol[i];
                    if(nrow >= 0 && nrow <n && ncol>=0 && ncol <m && mat[nrow][ncol] == initial && vis[nrow][ncol] == 0){
                        q.add(new Pair(nrow, ncol));
                        ans[nrow][ncol] = color;
                        vis[nrow][ncol] = 1;
                    }
                }
            }
        }
        return ans;
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
        int[][] ans = flood_filled(mat, 2, 0, 3);
        display(ans);
        sc.close();
               
    }
    
}
