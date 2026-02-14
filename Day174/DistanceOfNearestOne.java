package Day174;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DistanceOfNearestOne {
    static class Pair{
        int row;
        int col;
        int dist;
        Pair(int row,int col,int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
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
    static int[][] nearescellhavingZero(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] ans = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    vis[i][j] = 1;
                    q.add(new Pair(i, j,1));
                }
            }
        }
        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,-1,1};
        while(!q.isEmpty()){
            Pair top = q.poll();
            int row = top.row;
            int col = top.col;
            int dist= top.dist;
            for(int i = 0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<n && ncol >=0 && ncol<m && mat[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    ans[nrow][ncol] = dist;
                    q.add(new Pair(nrow, ncol, dist+1));
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
        int[][] ans = nearescellhavingZero(arr);
        display(ans);
        sc.close();

    }
    
}
