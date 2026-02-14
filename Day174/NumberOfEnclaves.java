package Day174;

import java.util.Scanner;

public class NumberOfEnclaves {
    static void dfs(int[][] mat, int[][] vis, int row,int col){
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,-1,1};
        for(int i = 0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col + dcol[i];
            if(nrow>=0 && nrow<n && ncol >=0 && ncol<m && mat[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                dfs(mat, vis, nrow, ncol);
            }
        }
    } 
    static int noOfIslands(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        for(int i = 0;i<n;i++){
            if(mat[i][0] == 1 && vis[i][0] == 0){
                dfs(mat,vis,i,0);
            }
            if(mat[i][m-1] == 1 && vis[i][m-1] == 0){
                dfs(mat,vis,i,m-1);
            }
        }
        for(int j = 0;j<m;j++){
            if(mat[0][j] == 1 && vis[0][j] == 0){
                dfs(mat,vis,0,j);
            }
            if(mat[n-1][j] == 1 && vis[n-1][j] == 0){
                dfs(mat,vis,n-1,j);
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 1 && vis[i][j] == 0) count++;
            }
        }
        return count;
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
        System.out.println(noOfIslands(arr));
        sc.close();
    }
    
}
