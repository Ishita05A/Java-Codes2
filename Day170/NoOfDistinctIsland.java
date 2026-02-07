package Day170;

import java.util.Scanner;

public class NoOfDistinctIsland {
    static void dfs(int row,int col, int[][] mat,int[][] vis){
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        for(int i = -1;i<=1;i++){
            for(int j = -1;j<=1;j++){
                int nrow = row+i;
                int ncol = col+j;
                if(nrow >= 0 && nrow<n && ncol >=0 && ncol<m && mat[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    dfs(nrow, ncol, mat, vis);
                }
            }
        }
    }
    static int countNoOfIsland(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 1 && vis[i][j] ==0){
                    dfs(i, j, mat, vis);
                    count++;
                }
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
        System.out.println(countNoOfIsland(arr));
        sc.close();
    }
    
}
