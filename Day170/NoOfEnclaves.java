package Day170;

import java.util.*;
public class NoOfEnclaves {
    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    static int countNoOfEnclaves(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>(); 
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if((i == 0 || i==n-1 || j == 0 || j==m-1) &&   mat[i][j] == 1){
                    q.add(new Pair(i, j));
                    vis[i][j] = 1;
                }
            }
        }
        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,1,-1};
        while(!q.isEmpty()){
            Pair top = q.poll();
            int row = top.row;
            int col = top.col;
            
            for(int i = 0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<n && ncol >=0 && ncol <m && mat[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                   vis[nrow][ncol] = 1;
                   q.add(new Pair(nrow, ncol));
                }
            }
        }
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
        System.out.println(countNoOfEnclaves(arr));
        sc.close();
    }
    
}
