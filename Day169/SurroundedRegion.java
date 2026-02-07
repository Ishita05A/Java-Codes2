package Day169;

import java.util.Scanner;

public class SurroundedRegion {
    static void display(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void dfs(int row, int col,char[][] mat,int[][] vis){
        int n = mat.length;
        int m = mat[0].length;
        vis[row][col] = 1;
        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,1,-1};
        for(int i = 0;i<4;i++){
            int nrow = row+drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<n && ncol >=0 && ncol <m && mat[nrow][ncol] == 'o' && vis[nrow][ncol] == 0){
                   dfs(nrow, ncol, mat, vis);
                }
        }
    }
    static char[][] surrounded_region(char[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        char[][] ans = new char[n][m];
        for(int i = 0;i<n;i++){
            if(mat[i][0] == 'o' && vis[i][0] == 0){
                dfs(i, 0, mat, vis);
            }
            if(mat[i][m-1] == 'o' && vis[i][m-1] == 0){
                dfs(i, m-1, mat, vis);
            }
        }
        for(int j = 0;j<m;j++){
            if(mat[0][j] == 'o' && vis[0][j] == 0){
                dfs(0, j, mat, vis);
            }
            if(mat[n-1][j] == 'o' && vis[n-1][j] == 0){
                dfs(n-1, j, mat, vis);
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(vis[i][j] == 0){
                    ans[i][j] = 'x';
                }
                else ans[i][j] = 'o';
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
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.next().charAt(0);
            }
        }
        char[][] ans = surrounded_region(arr);
        System.out.println();
        display(ans);
        sc.close();

    }
    
}
